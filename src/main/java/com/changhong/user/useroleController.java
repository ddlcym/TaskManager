package com.changhong.user;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: lenovo
 * Date: 16-2-25
 * Time: 下午5:30
 * To change this template use File | Settings | File Templates.
 */
public class useroleController extends AbstractController{
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("MANAGE_KEY","STRUCTURE")  ;
        return new ModelAndView("backend/user/userole",model);   //To change body of implemented methods use File | Settings | File Templates.
    }
}
