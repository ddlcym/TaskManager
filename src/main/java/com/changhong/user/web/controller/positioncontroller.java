package com.changhong.user.web.controller;

import com.changhong.user.service.PositionService;
import com.changhong.user.web.facade.dto.PositionDTO;
import com.changhong.user.web.facade.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: lenovo
 * Date: 16-3-2
 * Time: 下午2:48
 * To change this template use File | Settings | File Templates.
 */
public class positioncontroller extends SimpleFormController {
    //    @Override
//    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        Map<String, Object> model = new HashMap<String, Object>();
//        model.put("MANAGE_KEY", "STRUCTURE");
//        return new ModelAndView("backend/user/addposition", model);
//    }
    @Autowired
    private PositionService positionService;

    public positioncontroller() {
        setCommandClass(PositionDTO.class);
        setCommandName("position");
        setFormView("backend/user/addposition");
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        int posId = ServletRequestUtils.getIntParameter(request, "posId", -1);
        String name = ServletRequestUtils.getStringParameter(request, "name", "");
        String des = ServletRequestUtils.getStringParameter(request, "des", "");
        request.setAttribute("name", name);
        request.setAttribute("des", des);

        if (posId > 0) {
            return positionService.obtainPositionById(posId);
        }
        return new PositionDTO();
    }

    @Override
    protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors) throws Exception {
        super.onBindAndValidate(request, command, errors);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        String method = ServletRequestUtils.getStringParameter(request, "method");
        int posID = ServletRequestUtils.getIntParameter(request, "posID", -1);

        if ("add".equals(method)||"update".equals(method)) {
            System.out.println("add position");
//            PositionDTO posDTO=null;
//             Map<String, Object> model = new HashMap<String, Object>();
//            if(posID>0){
//               posDTO=positionService.obtainPositionById(posID);
//            }else{}{
//              posDTO=new PositionDTO();
//            }
//            model.put("",posDTO);
//            return new ModelAndView("backend/user/addposition",model);
        } else if ("delete".equals(method)) {
            System.out.println("delete position");
            positionService.deleteById(posID);
            return  new ModelAndView(new RedirectView("userpositionlist.html")) ;
        }
        PositionDTO positionDTO = (PositionDTO) command;

        positionService.saveOrUpPos(positionDTO);

        return new ModelAndView(new RedirectView("userpositionlist.html"));    //To change body of overridden methods use File | Settings | File Templates.
    }

    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }
}