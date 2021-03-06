<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/public/head.jspf" %>
	<style type="text/css">
    	#menu {
    		width:60px;
    		/* border:1px solid red;*/	
    	}
    	#menu ul {
    		list-style: none;
    		padding: 0px;
    		margin: 0px;
    	}
    	#menu ul li {
    		border-bottom: 1px solid #fff;
    	}
    	#menu ul li a:HOVER {
			background-color: #008792;
        }
    </style>
    <script type="text/javascript">
    	$(function(){
    		$("a[title]").click(function(){
    			var text = $(this).text();
    			var href = $(this).attr("title");
    			//判断当前右边是否已有相应的Tab
    			if($("#tt").tabs("exists",text)){
    				$("#tt").tabs("select",text);
    			} else {
    			//如果没有则创建一个新的Tab,否则切换到当前Tab
    			$("#tt").tabs("add",{
    				title:text,
    				closable:true,
    				content:'<iframe  title=' + text + ' src=' + href + ' frameborder="0" width="100%" hight="100%" />'
   				//href:默认通过url地址加载远程的页面，但是仅仅是body部分  
                //href:'send_category_query.action'
    			});
    			}
    		});
    	});
    </script>
 </head>
  
 <body class="easyui-layout">
    <div data-options="region:'north',title:'欢迎来到后台管理',split:true" style="height:100px;"></div>   
    <div data-options="region:'west',title:'系统操作',split:true" style="width:200px;">  
   		<!-- 此处显示的是系统菜单 --> 
   		<div id="menu" class="easyui-accordion" data-options="fit:true">   
    		<div title="基本操作" data-options="iconCls:'icon-save'" >   
        		<ul>
					<li><a href="#" title="department/sendDepartmentQuery">系别管理</a>
					<li><a href="#" title="course/sendCourseQuery">课程管理</a>
					<li><a href="#" title="student/sendStudentQuery">学生管理</a>
				</ul> 
    		</div>   
   			<div title="其他操作" data-options="iconCls:'icon-reload'">   
        		<ul>
					<li><a href="#" title="sc/sendInputGrade">学生成绩录入</a>
					<li><a href="#" title="sc/sendQueryGrade">学生个人成绩查询</a><!-- 含总分、平均分、排名（最后视情况实现） -->
					<li><a href="#" title="sc/sendQueryCourseGrade">学科成绩查询</a><!-- 含平均分、最高分、提供成绩范围查询 -->
				</ul>  
    		</div>  
    	</div> 
    </div> 
    <div data-options="region:'center',title:'后台操作页面'" style="padding:1px;background:#eee;">
    	<div id="tt" class="easyui-tabs" data-options="fit:true">
    		<div title="系统缺省页面" style="padding:10px;">
    			此处以后显示相应的系统信息（当前操作系统的类型，当前项目的域名，硬件的相关配置或者显示报表  ）
    		</div>
    	</div>
    </div>   
    <div id="win" data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"></div>

 </body>
</html> 