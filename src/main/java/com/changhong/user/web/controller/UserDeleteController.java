package com.changhong.user.web.controller;

import com.changhong.user.service.UserService;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * User: dangwei.pan
 * Date: 16-3-9
 * Time: 下午1:44
 */
public class UserDeleteController extends AbstractController{

    UserService userService;
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse httpServletResponse) throws Exception {

        int userId = ServletRequestUtils.getIntParameter(request,"userId",-1);

        userService.deleteUserById(userId);

        return new ModelAndView(new RedirectView("useroverview.html"));

    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
