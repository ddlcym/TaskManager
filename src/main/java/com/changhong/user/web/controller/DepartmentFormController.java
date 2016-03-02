package com.changhong.user.web.controller;

import com.changhong.user.service.DepartmentService;
import com.changhong.user.web.facade.dto.DepartmentCategoryDTO;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: di
 * Date: 16-3-1
 * Time: 下午3:31
 * To change this template use File | Settings | File Templates.
 */
public class DepartmentFormController extends AbstractController {

    private DepartmentService departmentService;

    private String fileRequestHost;


    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String method = ServletRequestUtils.getStringParameter(httpServletRequest, "method");
        int departmentId = ServletRequestUtils.getIntParameter(httpServletRequest, "departmentId", -1);
        String departmentName = ServletRequestUtils.getStringParameter(httpServletRequest, "departmentName", "");
        String principleUser = ServletRequestUtils.getStringParameter(httpServletRequest, "principleUser", "");
        String levelType = ServletRequestUtils.getStringParameter(httpServletRequest, "levelType", "");
        int parentId = ServletRequestUtils.getIntParameter(httpServletRequest, "parentId", -1);

        if ("save".equals(method)) {
            departmentService.saveOrUpdateDepartmentCategory(departmentId, departmentName,principleUser,levelType, parentId);
            return new ModelAndView(new RedirectView("departmentoverview.html"));
        } else {
            Map<String, Object> model = new HashMap<String, Object>();
            DepartmentCategoryDTO dto = null;
            if ("add".equals(method)) {
                dto = new DepartmentCategoryDTO();
            } else {
                dto = departmentService.obtainDepartmentCategoryById(departmentId);
            }
            List<DepartmentCategoryDTO> level_2 = departmentService.obtainCategoryByLevel("LEVEL_SECOND");
            List<DepartmentCategoryDTO> level_3 = departmentService.obtainCategoryByLevel("LEVEL_THIRD");
            model.put("category", dto);
            model.put("level_2", level_2);
            model.put("level_3", level_3);
            model.put("fileRequestHost", fileRequestHost);
            return new ModelAndView("backend/app/departmentform", model);
        }
    }

     public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void setFileRequestHost(String fileRequestHost) {
        this.fileRequestHost = fileRequestHost;
    }
}
