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
public class DepartmentController extends AbstractController {

    private DepartmentService departmentService;

    private String fileRequestHost;


    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String method = ServletRequestUtils.getStringParameter(httpServletRequest, "method");
        int departmentId = ServletRequestUtils.getIntParameter(httpServletRequest, "departmentId", -1);

        if ("add".equals(method) ||"edit".equals(method) ) {
            Map<String, Object> model = new HashMap<String, Object>();
            DepartmentCategoryDTO dto = null;
            String level="";
            if(departmentId > 0){
               dto=  departmentService.obtainDepartmentCategoryById(departmentId);
               level= dto.getLevelType();
               if(level.equals("LEVEL_FIRST"))level="";
               else if(level.equals("LEVEL_SECOND"))level="LEVEL_FIRST";
               else level="LEVEL_SECOND";

            }else{
                dto = new DepartmentCategoryDTO();
                level= "LEVEL_SECOND";
            }


            List<DepartmentCategoryDTO> parentDepartment = departmentService.obtainCategoryByLevel(level);
            model.put("department", dto);
            model.put("parentDepartment", parentDepartment);
            model.put("fileRequestHost", fileRequestHost);
            return new ModelAndView("backend/user/departmentform", model);
        }else if ("save".equals(method)) {
            saveOrUpdateDepartment(httpServletRequest,departmentId);
        }else if ("delete".equals(method)) {
            deleteDepartment(departmentId);
        }
        return new ModelAndView(new RedirectView("departmentoverview.html"));
    }

    private  void saveOrUpdateDepartment(HttpServletRequest httpServletRequest,int departmentId){
          String departmentName = ServletRequestUtils.getStringParameter(httpServletRequest, "departmentName", "");
          String principleUser = ServletRequestUtils.getStringParameter(httpServletRequest, "principleUser", "");
          String levelType = ServletRequestUtils.getStringParameter(httpServletRequest, "levelType", "");
          int parentId = ServletRequestUtils.getIntParameter(httpServletRequest, "parentId", -1);
          departmentService.saveOrUpdateDepartmentCategory(departmentId, departmentName,principleUser,levelType, parentId);
    }



    private  void deleteDepartment(int departmentId){
          departmentService.deleteDepartmentCategory(departmentId);
    }

     public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void setFileRequestHost(String fileRequestHost) {
        this.fileRequestHost = fileRequestHost;
    }
}
