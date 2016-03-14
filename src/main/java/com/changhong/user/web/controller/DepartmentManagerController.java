package com.changhong.user.web.controller;

import com.changhong.user.service.DepartmentService;
import com.changhong.user.web.facade.dto.DepartmentCategoryDTO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: di
 * Date: 16-3-2
 * Time: 下午12:00
 * To change this template use File | Settings | File Templates.
 */
public class DepartmentManagerController extends AbstractController {

    private DepartmentService departmentService;

    private String fileRequestHost;



    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        Map<String, Object> model = new HashMap<String, Object>();
        List<DepartmentCategoryDTO> departments = departmentService.obtainCategoryByLevel("LEVEL_FIRST");
        List<DepartmentCategoryDTO> list = new ArrayList<DepartmentCategoryDTO>();

        if(null !=departments){
            for(DepartmentCategoryDTO department:departments){
                  department.setIsLoad(true);
                  list.add(department);
                  List<DepartmentCategoryDTO> children=departmentService.obtainDepartmentWithChildren(department.getId());
                  if(null != children){
                      list.addAll(children);
                  }
            }
        }
        model.put("departments", list);
        model.put("fileRequestHost", fileRequestHost);
        return new ModelAndView("backend/user/departmentoverview", model);

    }


     public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void setFileRequestHost(String fileRequestHost) {
        this.fileRequestHost = fileRequestHost;
    }
}
