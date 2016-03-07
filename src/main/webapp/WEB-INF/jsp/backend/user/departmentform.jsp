<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>任务后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/uniform.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/maruti-style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/maruti-media.css" class="skin-color" />
    <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>

</head>
<body>
<%--内容部分***********************************************************--%>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <div class="widget-box">
                    <div class="widget-title">
                        <span class="icon">
                            <i class="icon-info-sign"></i>
                        </span>
                        <h5>添加/编辑部门/小组</h5>
                    </div>

                    <div class="widget-content nopadding">
                        <form action="${pageContext.request.contextPath}/backend/user/departmentform.html" method="post" class="form-horizontal" enctype="multipart/form-data">
                        <input type="hidden" id="departmentId" name="departmentId" value="${department.id}"/>
                        <input type="hidden" id="oldParentId" name="oldParentId" value="${department.parentID}"/>
                        <input type="hidden" name="method" value="save"/>
                        <div class="control-group">
                            <label class="control-label">组织类别名称 [必填]</label>
                            <div class="controls">
                                <input type="text" id="departmentName" name="departmentName" class="span20" value="${department.name}"/>
                                <span id="departmentName_help" class="help-block" style="display: none;">组织类别不能为空</span>
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label">组织负责人 [必填]</label>
                            <div class="controls">
                                <input type="text" id="principleUser" name="principleUser" class="span20" value="${department.principleUser}"/>
                                <span id="principleUser_help" class="help-block" style="display: none;">组织负责人不能为空</span>
                            </div>
                        </div>


                        <div class="control-group">
                            <label class="control-label">组织级别 [必填]</label>
                            <div class="controls">
                                <select id="levelType" name="levelType" value="department.levelType">
                                    <option value="LEVEL_FIRST" <c:if test="${department.levelType=='LEVEL_FIRST'}">selected="true"</c:if>>公司</option>
                                    <option value="LEVEL_SECOND"  <c:if test="${department.levelType=='LEVEL_SECOND'}">selected="true"</c:if>>部门</option>
                                    <option value="LEVEL_THIRD" <c:if test="${department.levelType=='LEVEL_THIRD'}">selected="true"</c:if>>小组</option>
                                </select>
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label">上级组织 </label>
                            <div class="controls">
                                <select id="parentId" name="parentId" value="department.parentId">
                                    <c:forEach items="${department.levelType=='LEVEL_SECOND'?level_1:level_2}" var="level">
                                           <option value="${level.id}" <c:if test="${department.parentID==level.id}">selected="true"</c:if>>${level.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>


                        <div class="form-actions">
                            <button type="button" class="btn btn-success" onclick="closePopup(settings.fadeOutTime);">取 消</button>
                            <button type="button" class="btn btn-success" onclick="saveDepartmentCategory(this.form);">保 存</button>
                        </div>
                    </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>