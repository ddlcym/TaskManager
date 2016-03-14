<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>任务后台管理系统</title>
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
    <script src="${pageContext.request.contextPath}/js/popup/modal.popup.js" type="text/javascript"></script>

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

        <div class="widget-content nopadding">
            <form action="${pageContext.request.contextPath}/backend/user/departmentform.html" method="post"
                  class="form-horizontal" enctype="multipart/form-data">
                <input type="hidden" id="departmentId" name="departmentId" value="${department.id}"/>
                <input type="hidden" id="oldParentId" name="oldParentId" value="${department.parentID}"/>
                <input type="hidden" name="method" value="save"/>

                <div class="control-button">

                    <button type="button" class="btn button-flat-primary" onclick="saveDepartmentCategory(this.form);">保
                        存
                    </button>
                    &nbsp;
                    <button type="button" class="btn button-flat-primary"
                            onclick="returnOverview('${pageContext.request.contextPath}/backend/user/departmentoverview.html');">
                        返回
                    </button>
                </div>


                <div class="control-group">
                    <label class="control-label">部门名称:</label>

                    <div class="controls">
                        <input type="text" id="departmentName" name="departmentName" class="span20"
                               value="${department.name}"/>
                        <span id="departmentName_help" class="help-block" style="display: none;">组织类别不能为空</span>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">部门负责人：</label>

                    <div class="controls">
                        <input type="text" id="principleUser" name="principleUser" class="span20"
                               value="${department.principleUser}"/>
                        <span id="principleUser_help" class="help-block" style="display: none;">组织负责人不能为空</span>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">级&nbsp;&nbsp;&nbsp;&nbsp;别：</label>

                    <div class="controls">
                        <select id="levelType" name="levelType" value="department.levelType"
                                onChange="setDepartmentLevel();">
                            <option value="LEVEL_THIRD"
                                    <c:if test="${department.levelType=='LEVEL_THIRD'}">selected="true"</c:if>>小组
                            </option>
                            <option value="LEVEL_SECOND"
                                    <c:if test="${department.levelType=='LEVEL_SECOND'}">selected="true"</c:if>>部门
                            </option>
                            <option value="LEVEL_FIRST"
                                    <c:if test="${department.levelType=='LEVEL_FIRST'}">selected="true"</c:if>>公司
                            </option>

                        </select>
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">上级部门： </label>

                    <div class="controls">
                        <select id="parentId" name="parentId" value="department.parentId">
                            <c:forEach items="${parentDepartment}" var="parent">
                                <option value=${parent.id}> ${parent.name} </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</div>


<script>

    function setDepartmentLevel() {
        var departementLevel = jQuery("#levelType").val();
        setParentDepartment(departementLevel);
    }

    function setParentDepartment(level) {
        var contentContainer = jQuery("#parentId");
        contentContainer.html("");
        var newContent = "";

        if (level == "LEVEL_FIRST") {
            newContent = "<option value='-1'>无</option>"
            contentContainer.html(newContent);
        } else {
            SystemDWRHandler.obtainRecommendDepartments(level, function(result) {
                var statisticData = JSON.parse(result);
                for (var i = 0; i < statisticData.length; i++) {
                    var departmentValues = statisticData[i];
                    newContent = newContent + "<option value=" + departmentValues.departmentId + ">" + departmentValues.departmentName + "</option>"
                }
                contentContainer.html(newContent);
            });
        }


    }


    function saveDepartmentCategory(form) {
        var parentId = jQuery("#parentId").val();
        var departmentId = jQuery("#departmentId").val();
        var departmentName = jQuery("#departmentName").val();
        var oldParentId = jQuery("#oldParentId").val();
        if (departmentName == null || departmentName == '') {
            jQuery("#categoryName_help").css("display", "block");
            return;
        } else {
            jQuery("#categoryName_help").css("display", "none");
        }
        form.submit();
    }


</script>
</body>
</html>