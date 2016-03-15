package com.changhong.user.web.controller;

import com.changhong.user.service.PositionService;
import com.changhong.user.web.facade.dto.PositionDTO;
import org.springframework.util.StringUtils;
import com.changhong.user.domain.DepartmentCategory;
import com.changhong.user.service.DepartmentService;
import com.changhong.user.service.UserService;
import com.changhong.user.web.facade.dto.DepartmentCategoryDTO;
import com.changhong.user.web.facade.dto.UserDTO;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: dangwei.pan
 * Date: 16-3-2
 * Time: 下午4:00
 */
public class UserAddController extends SimpleFormController{

    UserService userService;
    DepartmentService departmentService;
    PositionService positionService;

    //构造方法:1--设置command,2--指明表单页面
    public UserAddController() {
        setCommandClass(UserDTO.class);
        setCommandName("user");
        setFormView("/backend/user/useradd");
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        List<DepartmentCategoryDTO> level_ones = departmentService.obtainCategoryByLevel("LEVEL_FIRST");
        request.setAttribute("level_ones", level_ones);

        List<PositionDTO> positions = positionService.obtainAllPositions();
        request.setAttribute("positions",positions);

        int userId = ServletRequestUtils.getIntParameter(request, "userId", -1);

        //编辑用户使用
        if(userId > 0){

            UserDTO user = userService.obtainUserById(userId);
            DepartmentCategoryDTO departmentLevelTwo = departmentService.obtainDepartmentCategoryById(user.getDepartmentId());
            DepartmentCategoryDTO departmentLevelOne = departmentService.obtainDepartmentCategoryById(departmentLevelTwo.getParentID());

           return userService.obtainUserById(userId);

        }

        return new UserDTO();
    }

   // 后台信息验证
    @Override
    protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors) throws Exception {
        int userId = ServletRequestUtils.getIntParameter(request,"userId",-1);
        String userName = ServletRequestUtils.getStringParameter(request,"username","");
        if (!StringUtils.hasText(userName)) {
            errors.rejectValue("username", "user.username.empty");
        }

        String account = ServletRequestUtils.getStringParameter(request,"account","");
        if (!StringUtils.hasText(account)) {
            errors.rejectValue("account", "user.account.empty");
        }else {
            boolean exist = userService.obtainUserExist(userId, account);
            if (exist) {
                errors.rejectValue("account", "user.account.exist");
            }
        }

        String[] roles = ServletRequestUtils.getStringParameters(request, "roleUser");
        if (roles == null || roles.length <= 0) {
            errors.rejectValue("password", "user.role.empty");
        }

    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {

        //获取表单用户角色输入
        String[] roles = ServletRequestUtils.getStringParameters(request, "roleUser");

        //绑定的command对象转化为UserDto
         UserDTO userDTO = (UserDTO)command;

        //不能直接绑定到spring-form上的,要单独添加处理
        int levelThreeId = ServletRequestUtils.getIntParameter(request,"levelThreeId",-1);
        userDTO.setDepartmentId(levelThreeId);

        String userPosition = ServletRequestUtils.getStringParameter(request,"position","");
        userDTO.setPosition(userPosition);

        //清楚roles容器中的旧数据，防止数据重叠
        if(roles != null && roles.length > 0){
            if(userDTO.getRoles() != null){
                userDTO.getRoles().clear();
            }

            for (String role : roles){
                userDTO.grantRole(role);
            }
        }

        userService.changeUserDetails(userDTO);

        return new ModelAndView(new RedirectView("useroverview.html"));

    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }
}
