<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>应用市场后台管理系统</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/uniform.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/maruti-style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/maruti-media.css" class="skin-color"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/module.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/baseattribute.css"/>

    <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/maruti.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/dwr/engine.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/dwr/util.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/dwr/interface/SystemDWRHandler.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui-1.8.16.custom.min.js"
            type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui-1.8.22.custom.css"
          type="text/css"/>


</head>

<body>

<%--开头菜单部分***********************************************************--%>

<jsp:include page="/WEB-INF/jsp/backend/common/header.jsp"/>

<%--内容部分***********************************************************--%>
<div id="usermaincontent">
    <jsp:include page="/WEB-INF/jsp/backend/common/organization.jsp"/>
    <div id="maincontent">
        <spring-form:form commandName="position" class="form-horizontal" method="post" name="basic_validate"
                          id="basic_validate" novalidate="novalidate">
            <div class="btndiv">
                <input type="button" value="返 回" class="button button-flat-primary"
                       onclick="window.location.href='${pageContext.request.contextPath}/backend/user/userpositionlist.html'">
                &nbsp;
                <input type="submit" value="保 存" class="button button-flat-primary">
            </div>
            <div class="btndiv">
                <label class="name-label"><span style="color: red;">*</span>名称:</label>

                <div style="padding-bottom: 10px">
                    <spring-form:input path="name" maxlength="30" cssStyle="height: 30px;"/>&nbsp;
                    <spring-form:errors path="name" cssClass="help-inline"/>
                </div>

                <label class="name-label">描述:</label>

                <div>
                    <spring-form:textarea id="des" path="des" required="required" rows="8"
                                              cols="80" cssStyle="width: 500px;" maxlength="100" placeholder="请输入应用描述..."/>
                    <spring-form:errors path="des" cssClass="help-inline"/>
                </div>
            </div>
        </spring-form:form>
    </div>
</div>

</body>
</html>