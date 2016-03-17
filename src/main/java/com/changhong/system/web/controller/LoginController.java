package com.changhong.system.web.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: di
 * Date: 16-3-16
 * Time: 下午6:30
 * To change this template use File | Settings | File Templates.
 */
public class LoginController extends AbstractController {

    private String projectVersion;


    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("projectVersion", projectVersion);
        return new ModelAndView("backend/index", model); //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public void setProjectVersion(String projectVersion) {
        this.projectVersion = projectVersion;
    }
}
