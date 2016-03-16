package com.changhong.user.web.dwr;

import com.changhong.user.service.DepartmentService;
import com.changhong.user.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("systemDWRHandler")
public class SystemDWRHandler {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private UserService userService;

    public boolean obtainDepartmentHasChildren(int departmentId) {
        return departmentService.obtainDepartmentHasChildren(departmentId);
    }

     public String obtainRecommendDepartments(String level) throws JSONException {
        return departmentService.obtainRecommendDepartments(level).toString();
    }

    public String obtainChildrenDepartmentsById(int departmentId) throws JSONException{
        return departmentService.obtainChildrenDepartments(departmentId).toString();
    }

     public String obtainSubDepartments(int departmentId) throws JSONException {
        return departmentService.obtainSubDepartments(departmentId).toString();
    }

    public String obtainUserByDepartmentId(int departmentId) throws JSONException{
        return userService.obtainUserByDepartmentId(departmentId).toString();
    }
}
