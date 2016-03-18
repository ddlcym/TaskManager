<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="ch" uri="http://www.chanhong.com" %>

<!--Header-part-->
<div id="header">
    <h1><a href="javascript:void(0);">任务后台管理系统</a></h1>
</div>
<!--close-Header-part-->

<!--top-Header-messaages-->
<div class="btn-group rightzero">
    <a class="top_message tip-left" title="Manage Files"><i class="icon-file"></i></a>
    <a class="top_message tip-bottom" title="Manage Users"><i class="icon-user"></i></a>
    <a class="top_message tip-bottom" title="Manage Comments"><i class="icon-comment"></i><span
            class="label label-important">5</span></a>
    <a class="top_message tip-bottom" title="Manage Orders"><i class="icon-shopping-cart"></i></a>
</div>
<!--close-top-Header-messaages-->

<!--top-Header-menu-->
<%--<div id="user-nav" class="navbar navbar-inverse">--%>
    <%--<ul class="nav">--%>
        <%--<li class=""><a title="" href="javascript:void(0);"><i class="icon icon-user"></i> <span--%>
                <%--class="text"><ch:user/></span></a></li>--%>
        <%--<li class=""><a title="" href="${pageContext.request.contextPath}/backend/userchangepassword.html"><i--%>
                <%--class="icon icon-cog"></i> <span class="text">修改密码</span></a></li>--%>
        <%--<li class=""><a title="" href="${pageContext.request.contextPath}/j_spring_security_logout"><i--%>
                <%--class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>--%>
    <%--</ul>--%>
<%--</div>--%>
<!--close-top-Header-menu-->

<div id="sidebar" >
    <ul>
        <li class="active"><a href="${pageContext.request.contextPath}/backend/dashboard.html"><i
                class="icon icon-home"></i> <span>工作面板</span></a></li>

        <security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_DEPARTMENT_DIRECTOR,ROLE_GROUP_LEADER,ROLE_PRODUCT_MANAGER,ROLE_SOFTWARE_PM,ROLE_DEVELOPER,ROLE_ANONYMOUS">
            <li class="submenu"><a href="javascript:void(0);"><i class="icon icon-th"></i> <span>项目状态</span></a>
            </li>
        </security:authorize>

        <security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_DEPARTMENT_DIRECTOR,ROLE_GROUP_LEADER,ROLE_PRODUCT_MANAGER,ROLE_SOFTWARE_PM,ROLE_DEVELOPER,ROLE_ANONYMOUS">
            <li class="submenu"><a href="javascript:void(0);"><i class="icon icon-shopping-cart"></i> <span>任务列表</span></a>
            </li>
        </security:authorize>

        <security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_DEPARTMENT_DIRECTOR,ROLE_GROUP_LEADER,ROLE_PRODUCT_MANAGER,ROLE_SOFTWARE_PM,ROLE_DEVELOPER,ROLE_ANONYMOUS">
            <li class="submenu"><a href="javascript:void(0);"><i class="icon icon-share"></i> <span>经验分享</span></a>
            </li>
        </security:authorize>

        <security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_DEPARTMENT_DIRECTOR,ROLE_GROUP_LEADER,ROLE_PRODUCT_MANAGER,ROLE_SOFTWARE_PM,ROLE_DEVELOPER,ROLE_ANONYMOUS">
            <li class="submenu"><a href="javascript:void(0);"><i class="icon icon-th"></i> <span>组织架构</span></a>
            </li>
        </security:authorize>

        <security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_ANONYMOUS">
            <li class="submenu"><a href="javascript:void(0);"><i class="icon icon-edit"></i>
                <span>系统设置</span></a>
            </li>
        </security:authorize>

    </ul>
</div>