<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="ch" uri="http://www.chanhong.com" %>

<div id="navfirst">
    <ul class="back-con-l-ul">

         <h4><a href="javascript:void(0);"><i class="icon icon-th"></i> <span>组织架构</span></a></h4>

         <a href="${pageContext.request.contextPath}/backend/user/departmentoverview.html">
            <li <c:if test="${ORG_MENU_KEY == 'DEPARTMENT'}">class="cur"</c:if>>部门管理</li>
         </a>
        <a href="${pageContext.request.contextPath}/backend/user/useroverview.html">
            <li <c:if test="${ORG_MENU_KEY == 'PERSON'}">class="cur"</c:if>>人员管理</li>
         </a>
        <a href="${pageContext.request.contextPath}/backend/user/userpositionlist.html">
            <li <c:if test="${ORG_MENU_KEY == 'POSITION'}">class="cur"</c:if>>职位列表</li>
         </a>
        <a href="${pageContext.request.contextPath}/backend/user/userole.html">
            <li <c:if test="${ORG_MENU_KEY == 'ROLE'}">class="cur"</c:if>>角色权限</li>
         </a>
    </ul>
</div>