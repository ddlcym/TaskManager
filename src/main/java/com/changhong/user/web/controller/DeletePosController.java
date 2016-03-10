package com.changhong.user.web.controller;

import com.changhong.user.service.PositionService;
import com.changhong.user.web.facade.dto.PositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: cym
 * Date: 16-3-9
 * Time: 下午3:38
 * To change this template use File | Settings | File Templates.
 */
public class DeletePosController extends AbstractController {

    @Autowired
    private PositionService positionService=null;
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        int posId= ServletRequestUtils.getIntParameter(httpServletRequest,"posId",-1);
        positionService.deleteById(posId);

        Map<String, Object> model = new HashMap<String, Object>();
        List<PositionDTO> posDTOList=positionService.obtainAllPositions();
        model.put("posDTOList", posDTOList);
        return new ModelAndView("backend/user/userpositionlist", model);
    }

    public void setPositionService(PositionService positionService){
       this.positionService=positionService;
    }
}
