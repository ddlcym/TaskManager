<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="ch" uri="http://www.chanhong.com" %>

<div id="navfirst">
    <ul>
        <li class="line200"><a href="${pageContext.request.contextPath}/backend/user/departmentoverview.html" title="部门管理">部门管理</a>
        </li>
        <li class="line200"><a href="${pageContext.request.contextPath}/backend/user/usermanager.html" title="人员管理">人员管理</a>
        </li>
        <li class="line200"><a href="${pageContext.request.contextPath}/backend/user/userpositionlist.html" title="职位列表">职位列表</a>
        </li>
        <li class="line200"><a href="${pageContext.request.contextPath}/backend/user/userole.html" title="角色权限">角色权限</a>
        </li>
    </ul>
</div>