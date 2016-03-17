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
        <div id="add">
            <spring-form:form commandName="user" class="form-horizontal" method="post" name="basic_validate" id="basic_validate" novalidate="validate">
                <div id="form-action">
                   <input type="button" value="返 回" class="button button-flat-primary" onclick="window.location.href='${pageContext.request.contextPath}/backend/user/useroverview.html'"/>
                                &nbsp;&nbsp;
                   <input type="submit" value="保 存" class="button button-flat-primary"/>
                </div>

                <%--获取当前操作用户id--%>
                <input type="hidden" name="id" value="${user.id}"/>

                <div>
                    <label class="control-label"><span style="color: red;">*</span>姓名</label>
                    <div class="controls">
                        <spring-form:input path="username" placeholder="请输入姓名" required="required" cssStyle="height: 30px;"/>&nbsp;
                        <spring-form:errors path="username" cssClass="help-inline"/>
                    </div>
                </div>


                <div>
                    <label class="control-label">员工编号</label>
                    <div class="controls">
                        <spring-form:input path="employeeId" placeholder="请输入员工编号" cssStyle="height: 30px;"/>&nbsp;
                    </div>
                </div>

                <div>
                    <label class="control-label"><span style="color: red;">*</span>账户</label>
                    <div class="controls">
                        <c:set var="justRead" value="false"/>
                        <c:if test="${user.id > 0}">
                           <c:set var="justRead" value="true"/>
                        </c:if>
                        <spring-form:input path="account" placeholder="请输入登录账号" required="required" cssStyle="height: 30px;" readonly="${justRead}"/>&nbsp;
                        <spring-form:errors path="account" cssClass="help-inline"/>
                    </div>
                </div>

                <div>
                    <label class="control-label"><span style="color: red;">*</span>密码</label>
                    <div class="controls">
                        <spring-form:input type="password"  path="password" placeholder="请输入登录密码" required="required" cssStyle="height: 30px;"/>&nbsp;
                        <spring-form:errors path="password" cssClass="help-inline"/>
                    </div>
                </div>
                <div>
                    <label class="control-label">所属部门</label>
                    <div class="controls">
                        <select id="levelOneId" name="levelOneId" onclick="selectDepartmentLevelTwo()">
                            <option value=-1>-请选择- </option>
                            <c:forEach items="${firstLevel}" var="levelItem">
                                <option value=${levelItem.id}  <c:if test="${user.departmentLevel1==levelItem.name}">selected="true"</c:if>>
                                        ${levelItem.name}
                                </option>
                            </c:forEach>
                        </select>

                        <select id="levelTwoId" name="levelTwoId" onclick="selectDepartmentLevelThree()" <c:if test="${user.id < 0}">style="display: none"</c:if> >
                              <c:set var="departmentLevel2" value="${user.id >0?user.departmentLevel2:'-请选择-'}"></c:set>
                              <option value=-2>${departmentLevel2}</option>
                        </select>

                        <select id="departmentId" name="departmentId" value="user.departmentId" <c:if test="${user.id < 0}">style="display: none"</c:if>>
                            <c:set var="departmentLevel3" value="${user.id >0?user.departmentLevel3:'-请选择-'}"></c:set>
                              <%--<option value="${user.departmentId}">${departmentLevel3}</option>--%>
                              <option value="-3">${departmentLevel3}</option>
                        </select>
                    </div>

                </div>
                <div>
                    <label class="control-label">职位</label>
                    <div class="controls">
                        <select name="position"  value="user.position">
                            <c:forEach items="${positions}" var="position">
                                <option value="${position.name}" <c:if test="${user.id > 0}">selected="true" </c:if>>
                                    ${position.name}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <div>
                    <label class="control-label">Email</label>
                    <div class="controls">
                        <spring-form:input path="Email" maxlength="30" placeholder="请输入Email" cssStyle="height: 30px;"/>&nbsp;
                    </div>
                </div>
                <div>
                    <label class="control-label">地址</label>
                    <div class="controls">
                        <spring-form:input path="address" maxlength="30" placeholder="请输入地址" cssStyle="height: 30px;"/>&nbsp;
                    </div>
                </div>
                <div>
                        <label class="control-label"><span style="color: red;">*</span>系统角色</label>
                        <div class="controls">
                            <label>
                                <input type="checkbox" name="roleUser" value="ROLE_ADMIN"
                                    <c:if  test="${user.hasRoleAdmin}"> checked</c:if>
                                                                />&nbsp;&nbsp;系统管理
                            </label>

                            <label><input type="checkbox" name="roleUser" value="ROLE_DEPARTMENT_DIRECTOR"
                                    <c:if  test="${user.hasRoleDepartmentDirector}"> checked</c:if>
                                                                />&nbsp;&nbsp;部长</label>

                            <label><input type="checkbox" name="roleUser" value="ROLE_GROUP_LEADER"
                                    <c:if  test="${user.hasRoleGroupLeader}"> checked</c:if>
                                                                />&nbsp;&nbsp;组长</label>

                            <label><input type="checkbox" name="roleUser" value="ROLE_PRODUCT_MANAGER"
                                    <c:if  test="${user.hasRoleProductManager}"> checked</c:if>
                                                                />&nbsp;&nbsp;项目经理</label>

                            <label><input type="checkbox" name="roleUser" value="ROLE_SOFTWARE_PM"
                                    <c:if  test="${user.hasRoleSoftwarePM}"> checked</c:if>
                                                                />&nbsp;&nbsp;软件负责人</label>
                            <label><input type="checkbox" name="roleUser" value="ROLE_HARDWARE_PM"
                                    <c:if  test="${user.hasRoleHardwarePM}"> checked</c:if>
                                                                />&nbsp;&nbsp;硬件负责人</label>
                            <label><input type="checkbox" name="roleUser" value="ROLE_DEVELOPER"
                                    <c:if  test="${user.hasRoleDeveloper}"> checked</c:if>
                                                                />&nbsp;&nbsp;开发人员</label>
                            <spring-form:errors path="roles" cssClass="help-inline"/>
                        </div>
                </div>

            </spring-form:form>
        </div>
    </div>
</div>

<%--------------------------------------------JavaScript部分----------------------------------------------------%>
<script>

    function selectDepartmentLevelTwo(){
        var parentId = jQuery("#levelOneId").val();  //获取所选一级部门id
        jQuery("#levelTwoId").css("display","inline");
        setLeveloneChildrenDepartment(parentId);
    }

    function setLeveloneChildrenDepartment(id){
        var content = jQuery("#levelTwoId"); //获得二级部门子对象
        content.html("");
        var newContent = "";

        if(id>0) {
            SystemDWRHandler.obtainSubDepartments(id,function(result){
                var statisticData = JSON.parse(result);
                for(var i=0; i<statisticData.length; i++) {
                    var department = statisticData[i];
                    newContent += "<option value="+department.departmentId+">"+department.departmentName+"</option>"
                }
                content.html(newContent);
            });
      }else{
            newContent = "<option value='-2'>-请选择-</option>"
            jQuery("#levelTwoId").css("display","none");
            content.html(newContent);
            selectDepartmentLevelThree();
        }
    }



    function selectDepartmentLevelThree(){
        var parentId = jQuery("#levelTwoId").val();
        jQuery("#departmentId").css("display","inline");
        setLevelTwoChildrenDepartment(parentId);

    }

    function setLevelTwoChildrenDepartment(id){
        var content = jQuery("#departmentId"); //获得三级部门子对象
        content.html("");
        var newContent = "";

        if(id>0){
          SystemDWRHandler.obtainSubDepartments(id,function(result){
            var statisticData = JSON.parse(result);
            for(var i=0; i<statisticData.length; i++) {
                var department = statisticData[i];
                newContent +="<option value="+department.departmentId+">"+department.departmentName+"</option>"
            }
            content.html(newContent);
        });
        }else{
            newContent = "<option value='-3'>-请选择-</option>"
            jQuery("#departmentId").css("display","none");
            content.html(newContent);
        }

    }




</script>

</body>
</html>


