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
                <a id="button" href="${pageContext.request.contextPath}/backend/user/departmentform.html?departmentId=-1&method=add" class="button button-flat-primary">添加部门</a>
            </div>
            <table class="table table-bordered position-tab">
                <thead >
                <tr>
                    <th class="no" >序号</th>
                    <th class="orgname" >组织名称</th>
                    <th class="orgleader" >组织负责人</th>
                    <th class="level" >级别</th>
                    <th class="parent" >上级部门</th>
                    <th class="detail" >详情</th>
                    <th class="detail" >编辑</th>
                </tr>
                </thead>

                 <tbody>
                <c:forEach items="${departments}" var="department" varStatus="status">
                    <tr class="gradeX">
                      <td>${status.count}</td>
                      <td>${department.name}</td>
                      <td>${department.principleUser}</td>
                      <td>
                        <c:if test="${department.levelType == 'LEVEL_FIRST'}">
                        公司(一级)
                        </c:if>
                        <c:if test="${department.levelType == 'LEVEL_SECOND'}">
                        部门(二级)
                        </c:if>
                        <c:if test="${department.levelType == 'LEVEL_THIRD'}">
                        小组(三级)
                        </c:if>
                      </td>
                      <td>${department.parentID}</td>
                      <td>更多</td>

                      <td class="more-details">
                        <a href="javascript:void(0);" onclick="openDepartmentDialog('${department.id}', 'edit');" class="btn btn-primary btn-mini">修改</a>
                        <a href="javascript:void(0);" onclick="departmentDeleteConfirm('${department.id}');"  class="btn btn-primary btn-mini">删除</a>

                      </td>
                    </tr>
                </c:forEach>
              </tbody>
            </table>
        </div>

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
			align : 'center',									//Valid values, left, right, center
			top : 50, 											//Use an integer (in pixels)
			width : 600, 										//Use an integer (in pixels)
			padding : 10,										//Use an integer (in pixels)
	        backgroundColor : 'white', 						    //Use any hex code
	        source : '', 				    					//Refer to any page on your server, external pages are not valid e.g. http://www.google.co.uk
	        borderColor : '#333333', 							//Use any hex code
	        borderWeight : 4,									//Use an integer (in pixels)
	        borderRadius : 5, 									//Use an integer (in pixels)
	        fadeOutTime : 300, 									//Use any integer, 0 : no fade
	        disableColor : '#666666', 							//Use any hex code
	        disableOpacity : 40, 								//Valid range 0-100
	        loadingImage : '${pageContext.request.contextPath}/js/popup/loading.gif'
		};
		jQuery(document).keyup(function(event) {
			if (event.keyCode == 27) {
				closePopup(settings.fadeOutTime);
			}
		});

	});
	function openDepartmentDialog(id, method) {
		settings.source = '${pageContext.request.contextPath}/backend/user/departmentform.html?departmentId=' + id + '&method=' + method;
		openModalPopup(settings);
	}

    function openModalPopup(obj) {
		modalPopup(obj.align, obj.top, obj.width, obj.padding, obj.disableColor, obj.disableOpacity, obj.backgroundColor, obj.borderColor, obj.borderWeight, obj.borderRadius, obj.fadeOutTime, obj.source, obj.loadingImage);
	}



     function saveDepartmentCategory(form) {
        var parentId = jQuery("#parentId").val();
        var departmentId = jQuery("#departmentId").val();
        var departmentName = jQuery("#departmentName").val();
        var oldParentId = jQuery("#oldParentId").val();
        if(departmentName == null || departmentName == '') {
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
                            if(result) {
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
                                window.location.href = '${pageContext.request.contextPath}/backend/user/departmentdelete.html?departmentId=' + departmentId+'&method=delete';
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

</script>

</body>
</html>