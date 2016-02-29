<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="ch" uri="http://www.chanhong.com" %>

<div id="navfirst">
    <ul>
        <li class="line200"><a href="${pageContext.request.contextPath}/backend/user/userorgstructure.html" title="组织架构">组织架构</a>
        </li>
        <li class="line200"><a href="${pageContext.request.contextPath}/backend/user/userpositionlist.html" title="职位列表">职位列表</a>
        </li>
        <li class="line200"><a href="${pageContext.request.contextPath}/backend/user/userole.html" title="角色权限">角色权限</a>
        </li>
    </ul>
</div>