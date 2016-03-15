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
            <input type="button" class="button button-flat-primary" value="添加用户"
                   onclick="window.location.href = '${pageContext.request.contextPath}/backend/user/useradd.html'"/>
            <table id="table_department" class="table table-bordered position-tab">
                <thead>
                    <tr>
                        <th style="width: 25%;text-align: center;">部门/姓名</th>
                        <th>员工编号</th>
                        <th>用户名</th>
                        <th>职位</th>
                        <th style="width: 10%">Email</th>
                        <th>地址</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody id="table table-list">
                    <c:forEach items="${departments}" var="department" varStatus="status">
                        <tr id="${department.id}" parentId="${department.parentID}" isDepart="${department.isBranchNode}" isLoad="${department.isLoad}">
                              <td>
                                    <c:choose>
                                       <c:when test="${department.levelType=='LEVEL_FIRST'}">
                                           <a href="javascript:void(0);" onclick="toggleDepart('${department.id}');"><span class="icon"><i id="icon_${department.id}" class="icon-minus"></i></span></a>
                                       </c:when>
                                       <c:when test="${department.levelType=='LEVEL_SECOND'}">
                                              &nbsp; &nbsp; &nbsp;<a href="javascript:void(0);" onclick="toggleDepart('${department.id}');"><span class="icon"><i id="icon_${department.id}" class="icon-plus"></i></span></a>
                                       </c:when>
                                       <c:otherwise>
                                              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                       </c:otherwise>
                                    </c:choose>
                                      "${department.name}"
                              </td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td class="more-details">
                                    <a href="${pageContext.request.contextPath}/backend/user/useradd.html?userId=${user.id}"><i
                                            class="icon-pencil icon-white"></i></a>&nbsp; &nbsp;&nbsp; &nbsp;
                                    <a title="" href="javascript:void(0);" onclick="userDeleteConfirm('${user.id}');"><i
                                            class="icon-remove icon-white"></i></a>
                              </td>

                        </tr>
                    </c:forEach>



                    <%--<c:forEach items="${users}" var="user">--%>
                        <%--<tr>--%>
                            <%--<td>${user.username}</td>--%>
                            <%--<td>${user.employeeId}</td>--%>
                            <%--<td>${user.account}</td>--%>
                            <%--<td>${user.position}</td>--%>
                            <%--<td>${user.email}</td>--%>
                            <%--<td>${user.address}</td>--%>
                            <%--<td class="actions">--%>
                                <%--<a href="${pageContext.request.contextPath}/backend/user/useradd.html?userId=${user.id}"><i--%>
                                        <%--class="icon-pencil icon-white"></i></a>--%>
                                <%--<a title="" href="javascript:void(0);" onclick="userDeleteConfirm('${user.id}');"><i--%>
                                        <%--class="icon-remove icon-white"></i></a>--%>
                            <%--</td>--%>
                        <%--</tr>--%>
                    <%--</c:forEach>--%>

                </tbody>

            </table>
        </div>
    </div>
</div>


<div id="user_delete_dialog" title="删除用户" style="visibility: hidden;">
    <p>
        <span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
        确定要删除该用户么？
    </p>
</div>

<%-------------------------JS部分----------------------------------%>
<script>

    function userDeleteConfirm(userId) {
        jQuery("#user_delete_dialog").css("visibility", "visible");
        jQuery("#user_delete_dialog").dialog({
                    resizable: false,     //对话框尺寸大小不变
                    height:160,
                    width:300,
                    modal: true,
                    buttons: {
                        "确  认": function() {
                            jQuery("#user_delete_dialog").css("visibility", "hidden");
                            jQuery(this).dialog("close");
                            window.location.href = '${pageContext.request.contextPath}/backend/user/userdelete.html?userId=' + userId;
                        },
                        "取  消": function() {
                            jQuery("#user_delete_dialog").css("visibility", "hidden");
                            jQuery(this).dialog("close");
                        }
                    }
                });
    }

    function toggleDepart(tr){
        var branchNode = jQuery("#"+tr);   //获取当前部门
        var icon=jQuery("#icon_"+tr);      //获取当前的Icon
        if(icon.attr("class") == "icon-minus"){     //"-"变成"+"
            icon.attr("class","icon-plus");
            hideSubDepartment(tr);             //隐藏子部门
        }else{
            icon.attr("class","icon-minus");
            showSubDepartment(branchNode);    //"+"变"-",显示子部门
        }
     }

    function showSubDepartment(branchNode){
             var id= branchNode.attr("id");
            //获取当前部门ID值
            if("true" == branchNode.attr("isLoad")){
                    refresh(id);
            }else{
                SystemDWRHandler.obtainSubDepartments(id, function(result) {
                var statisticData = JSON.parse(result);
                var html = "";
                for(var i=0; i<statisticData.length; i++) {
                    var departmentValues = statisticData[i];
                    html = "<tr id='" + departmentValues.departmentId + "' parentId='" + departmentValues.parentID + "' isDepart='" + departmentValues.isDepart +"' isLoad='"+departmentValues.isLoad+"'>";

                    html += "<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"<a href='javascript:void(0);' onclick='toggleDepart('departmentValues.id');'>"+'<span class="icon">'+'<i id="icon_departmentValues.id" class="icon-plus"></i>'+'</span>'+departmentValues.departmentName+"</a>"+"</td>";
                    html += "<td>"+"</td>";
                    html += "<td>"+"</td>";
                    html += "<td>"+"</td>";
                    html += "<td>"+"</td>";
                    html += "<td>"+"</td>";
                    html += "<td class='more-details'>"+
                            "<a href='${pageContext.request.contextPath}/backend/user/useradd.html?userId=${user.id}' class='icon-pencil icon-white'></a>&nbsp; &nbsp;&nbsp; &nbsp;<a  href='javascript:void(0);' onclick='userDeleteConfirm('${user.id}');' class='icon-remove icon-white'></a></td>";

                    html += "</tr>";
                    //获取要插入行的表格
                   branchNode.after(html)
            }
            branchNode.attr("isLoad","true");
        });

            }

         }

    function hideSubDepartment(id){
          $("#table_department tr").each(function(){
                var tem =$(this).attr("parentId");
                if(tem== id ){
                   $(this).hide();
                }
            });
     }

     function refresh(id){
          $("#table_department tr").each(function(){
                var tem =$(this).attr("parentId");
                if(tem== id ){
                   $(this).show();
                }
            });
     }



</script>


</body>
</html>

