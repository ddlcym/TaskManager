package com.changhong.user.web.controller;

import com.changhong.user.service.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * User: dangwei.pan
 * Date: 16-3-2
 * Time: 下午3:44
 */
public class UserManagerController extends AbstractController{


    UserService userService;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();

        model.put("MANAGE_KEY","STRUCTURE")  ;
        return new ModelAndView("backend/user/usermanager",model);
    }

    public void setUserService(UserService userService) {
           this.userService = userService;
       }

}
