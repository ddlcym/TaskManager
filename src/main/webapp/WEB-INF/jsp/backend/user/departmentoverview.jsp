<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>任务管理后台管理系统</title>
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
        <div id="add">
            <div class="mybutton">
                     <input type="button" class="button button-flat-primary" value="添加部门"
                                     onclick="openDepartmentDialog('${department.id}', 'add');"/>

            </div>
            <table id="table_department" class="table table-bordered position-tab">
                <thead>
                <tr>
                    <th class="no">序号</th>
                    <th class="orgname">名称</th>
                    <th class="orgleader">负责人</th>
                    <th class="edit">操作</th>

                </tr>
                </thead>

                <tbody id="table table-list">
                <c:forEach items="${departments}" var="department" varStatus="status">
                    <tr id="${department.id}" parentId="${department.parentID}" isDepart="${department.isBranchNode}"
                        isLoad="${department.isLoad}">
                        <td></td>
                        <td>
                            <c:choose>
                                <c:when test="${department.levelType=='LEVEL_FIRST'}">
                                    <a href="javascript:void(0);" onclick="toggleDepart('${department.id}');"><span
                                            class="icon"><i id="icon_${department.id}"
                                                            class="icon-minus"></i></span></a>
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
                        <td>${department.principleUser}</td>
                        <td class="more-details">
                            <a href="javascript:void(0);" onclick="openDepartmentDialog('${department.id}', 'edit');"><i class="icon-pencil icon-white"></i></a>
                            &nbsp; &nbsp; <a href="javascript:void(0);" onclick="departmentDeleteConfirm('${department.id}');">
                               <i class="icon-remove icon-white"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>

    </div>
</div>


<div id="department_delete_dialog" title="确认对话框?" style="visibility: hidden;">
    <p>
        <span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
        请确认你是否要删除该部门/小组？
    </p>
</div>

<div id="department_delete_refuse" title="确认对话框?" style="visibility: hidden;">
    <p>
        <span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
        该部门/小组下已经存在，请转移后再删除。
    </p>
</div>

<script>
    jQuery(function() {
        settings = {
            align : 'center',                                    //Valid values, left, right, center
            top : 50,                                             //Use an integer (in pixels)
            width : 600,                                         //Use an integer (in pixels)
            padding : 10,                                        //Use an integer (in pixels)
            backgroundColor : 'white',                             //Use any hex code
            source : '',                                         //Refer to any page on your server, external pages are not valid e.g. http://www.google.co.uk
            borderColor : '#333333',                             //Use any hex code
            borderWeight : 4,                                    //Use an integer (in pixels)
            borderRadius : 5,                                     //Use an integer (in pixels)
            fadeOutTime : 300,                                     //Use any integer, 0 : no fade
            disableColor : '#666666',                             //Use any hex code
            disableOpacity : 40,                                 //Valid range 0-100
            loadingImage : '${pageContext.request.contextPath}/js/popup/loading.gif'
        };
        jQuery(document).keyup(function(event) {
            if (event.keyCode == 27) {
                closePopup(settings.fadeOutTime);
            }
        });

    });
    function openDepartmentDialog(id, method) {
        window.open('${pageContext.request.contextPath}/backend/user/departmentform.html?departmentId=' + id + '&method=' + method, "_self")
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


    function departmentDeleteConfirm(departmentId) {
        jQuery("#department_delete_dialog").css("visibility", "visible");
        jQuery("#department_delete_dialog").dialog({
                    resizable: false,
                    height:160,
                    width:300,
                    modal: true,
                    buttons: {
                        "确  认": function() {
                            jQuery("#department_delete_dialog").css("visibility", "hidden");
                            jQuery("#department_delete_dialog").dialog("close");
                            SystemDWRHandler.obtainDepartmentHasChildren(departmentId, function(result) {
                                if (result) {
                                    jQuery("#department_delete_refuse").css("visibility", "visible");
                                    jQuery("#department_delete_refuse").dialog({
                                                resizable: false,
                                                height:160,
                                                width:300,
                                                modal: true,
                                                buttons: {
                                                    "取  消": function() {
                                                        jQuery("#department_delete_refuse").css("visibility", "hidden");
                                                        jQuery(this).dialog("close");
                                                    }
                                                }
                                            });
                                } else {
                                    jQuery("#department_delete_refuse").dialog("close");
                                    window.location.href = '${pageContext.request.contextPath}/backend/user/departmentdelete.html?departmentId=' + departmentId + '&method=delete';
                                }
                            });

                        },
                        "取  消": function() {
                            jQuery("#department_delete_dialog").css("visibility", "hidden");
                            jQuery(this).dialog("close");
                        }
                    }
                });
    }


    function toggleDepart(tr) {
        var branchNode = jQuery("#" + tr);
        var icon = jQuery("#icon_" + tr);
        if (icon.attr("class") == "icon-minus") {
            icon.attr("class", "icon-plus");
            hideSubDepartment(tr);
        } else {
            icon.attr("class", "icon-minus");
            showSubDepartment(branchNode);
        }
    }
    function showSubDepartment(branchNode) {
        var id = branchNode.attr("id");
        //获取ID值
        if ("true" == branchNode.attr("isLoad")) {
            refresh(id);
        } else {
            SystemDWRHandler.obtainSubDepartments(id, function(result) {
                var statisticData = JSON.parse(result);
                var html = "";
                for (var i = 0; i < statisticData.length; i++) {
                    var departmentValues = statisticData[i];
                    html = "<tr id='" + departmentValues.departmentId + "' parentId='" + departmentValues.parentID + "' isDepart='" + departmentValues.isDepart + "' isLoad='" + departmentValues.isLoad + "'>";
                    html += "<td>" + "</td>";
                    if (departmentValues.levelType == "LEVEL_FIRST") {
                        html += "<td><a href='javascript:void(0);' onclick='toggleDepart('" + departmentValues.departmentId + "');'><span class='icon'><i class='icon-minus'></i></span></a>" + departmentValues.departmentName + "</td>";
                    } else if (departmentValues.levelType == "LEVEL_SECOND") {
                        html += "<td>&nbsp;&nbsp;&nbsp;<a href='javascript:void(0);' onclick='toggleDepart('" + departmentValues.departmentId + "');'><span class='icon'><i class='icon-minus'></i></span></a>" + departmentValues.departmentName + "</td>";
                    } else {
                        html += "<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + departmentValues.departmentName + "</td>";
                    }
                    html += "<td>" + departmentValues.principleUser + "</td>";
                    html += "<td class='more-details'><a href='javascript:void(0);' onclick='openDepartmentDialog('" + departmentValues.departmentId + "', 'edit');'><i class='icon-pencil icon-white'></i></a>";
                    html += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:void(0);' onclick='departmentDeleteConfirm('" + departmentValues.departmentId + "');'><i class='icon-remove icon-white'></i></a></td>";
                    html += "</tr>";
                    //获取要插入行的表格
                    branchNode.after(html)
                }
                branchNode.attr("isLoad", "true");
            });
        }
    }


    function hideSubDepartment(id) {
        $("#table_department tr").each(function() {
            var tem = $(this).attr("parentId");
            if (tem == id) {
                $(this).hide();
                if ("true" == $(this).attr("isDepart")) {
                    var curID = $(this).attr("id");
                    jQuery("#icon_" + curID).attr("class", "icon-plus");
                    hideSubDepartment(curID);
                }
            }
        });
    }

    function refresh(id) {
        $("#table_department tr").each(function() {
            var tem = $(this).attr("parentId");
            if (tem == id) {
                $(this).show();
            }
        });
    }

</script>

</body>
</html>