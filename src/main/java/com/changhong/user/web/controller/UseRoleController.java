package com.changhong.user.web.controller;

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
public class UseRoleController extends AbstractController{

     String[] roleTypes={
     "系统管理员",//ROLE_ADMIN"
     "部长", //ROLE_DEPARTMENT_DIRECTOR
     "组长",//ROLE_GROUP_LEADER
     "项目经理",//ROLE_PRODUCT_MANAGER
     "软件负责人",//ROLE_SOFTWARE_PM
     "硬件负责人",//ROLE_HARDWARE_PM
     "开发人员"//ROLE_DEVELOPER
     };
    String[] roleDescription={
     "项目管理：查看、创建、编辑、关闭所有项目的信息，添加项目成员；\t\n" +
             "\t任务管理：查看任务、创建任务、编辑任务、删除任务、跨责任人执行任务；\n" +
             "\t组织架构管理：查看组织架构、管理职位列表、管理角色权限、管理组织架构。\n" +
             "\t系统管理：修改个人密码、修改系统名称、任务编号规则、定制系统字段、定制系统表单、配置邮件发送、清理数据、邮件发送配置。",//ROLE_ADMIN"
     "拥有管理员权限。（系统管理只拥有修改个人密码权限）\t\n" +
             "\t项目管理：查看、创建、编辑、关闭所有项目的信息，添加项目成员；\t\n" +
             "\t任务管理：查看任务、创建任务、编辑任务、删除任务、跨责任人执行任务；\n" +
             "\t组织架构管理：查看组织架构、管理职位列表、管理角色权限、管理组织架构。\n" +
             "\t系统管理：修改个人密码。", //ROLE_DEPARTMENT_DIRECTOR
     "查看小组内所有人员参与的项目信息，非组内人员参与项目不能查看；\n" +
             "\t项目管理：可查看项目、创建项目、编辑项目、关闭项目，添加项目成员、指定软件负责人。\n" +
             "\t任务管理：查看任务、创建任务、编辑任务、删除任务、跨责任人执行任务；\n" +
             "\t组织架构管理：查看组织架构。\n" +
             "\t系统管理：修改个人密码。",//ROLE_GROUP_LEADER
     "可查看所属项目下的所有任务。\n" +
             "\t项目管理：可查看项目、创建项目、编辑项目、关闭项目、添加项目成员。\n" +
             "\t任务管理：查看任务、创建任务、编辑任务、删除任务、跨责任人执行任务；\n" +
             "\t组织架构管理：查看组织架构。\n" +
             "\t系统管理：修改个人密码。",//ROLE_PRODUCT_MANAGER
     "可查看所属项目下的所有任务。\n" +
             "\t项目管理：可查看项目、创建项目、编辑项目、关闭项目，添加项目成员。\n" +
             "\t任务管理：查看任务、创建任务、编辑任务、删除任务、跨责任人执行任务；\n" +
             "\t组织架构管理：查看组织架构。\n" +
             "\t系统管理：修改个人密码。",//ROLE_SOFTWARE_PM
     "同软件负责人",//ROLE_HARDWARE_PM
     "可查看本人参与的项目信息。以及该项目当前阶段下的所有任务信息。但只能编辑与查看属于自己的任务。项目内其他人的任务只可查看，不可编辑。开发人员不具备创建和关闭任务的权限。\n" +
             "\t项目管理：可查看项目。\n" +
             "\t任务管理：查看任务（所属项目内的所有任务）、执行任务、（执行任务必须责任人为本人时，方可操作）\n" +
             "\t组织架构管理：无。\n" +
             "\t系统管理：修改个人密码。"//ROLE_DEVELOPER
     };
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();

        model.put("roleSize",roleTypes.length);
        model.put("roleTypes",roleTypes);
        model.put("roleDescription",roleDescription);
        model.put("ORG_MENU_KEY", "ROLE");

        return new ModelAndView("backend/user/userole",model);   //To change body of implemented methods use File | Settings | File Templates.
    }
}
