package com.changhong.user.web.controller;

import com.changhong.user.service.PositionService;
import com.changhong.user.web.facade.dto.PositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: lenovo
 * Date: 16-2-25
 * Time: 下午5:28
 * To change this template use File | Settings | File Templates.
 */
public class UserPositionController extends AbstractController {

    @Autowired
    private PositionService positionService;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        List<PositionDTO> posDTOList=positionService.obtainAllPositions();
        if(null != posDTOList){
            model.put("posDTOList", posDTOList);
        }

        model.put("ORG_MENU_KEY", "POSITION");
        return new ModelAndView("backend/user/userpositionlist", model);
    }

    public void setPositionService(PositionService positionService){
        this.positionService=positionService;
    }
}
