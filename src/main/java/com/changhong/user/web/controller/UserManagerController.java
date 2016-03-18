package com.changhong.user.web.controller;

import com.changhong.user.service.DepartmentService;
import com.changhong.user.service.UserService;
import com.changhong.user.web.facade.dto.DepartmentCategoryDTO;
import com.changhong.user.web.facade.dto.UserDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: dangwei.pan
 * Date: 16-3-2
 * Time: 下午3:44
 */
public class UserManagerController extends AbstractController{


    UserService userService;
    DepartmentService departmentService;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();

        List<DepartmentCategoryDTO> departments = departmentService.obtainCategoryByLevel("LEVEL_FIRST");
        List<DepartmentCategoryDTO> list = new ArrayList<DepartmentCategoryDTO>();

        //一级和二级元素全放到List中,三级元素从页面上加载
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
        model.put("ORG_MENU_KEY", "PERSON");

        return new ModelAndView("backend/user/useroverview",model);
    }

    public void setUserService(UserService userService) {
           this.userService = userService;
       }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
}
