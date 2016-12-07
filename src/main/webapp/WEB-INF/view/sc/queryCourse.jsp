<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/public/head.jspf"%>
<style type="text/css">
body {
	margin: 1px;
}

.searchbox {
	margin: -3;
}
</style>
<script type="text/javascript">
	$(function() {
		$('#name').validatebox({
			required : true,
			missingMessage : '请输入学科名'
		});
		
		
		$("#form").form("disableValidation");
		$("#submit").click(function() {
			$("#form").form("enableValidation");
			if ($("#form").form("validate")) {
				$("#form").form('submit', {
					url :'queryCourseGrade',
					success : function(data) {
						var data = eval('(' + data + ')');
						if (data.result == "true") {
						$("#errorDiv").hide();
							 $("#div").show();
							var Str_temp = "<h>"+data.course+"学科成绩表</h><table><tr><th>姓名</th><th>系别</th><th>成绩</th></tr>";
				            var gradeValue = "";
				            obj =data.Grades;
				            alert(obj);
				            for(var i=0;i<obj.length;i++){
				             Str_temp += "<tr><td>" + obj[i].sname + "</td><td>" + obj[i].dname + "</td><td>"+obj[i].grade 
				             +"</td><td></tr>";
								
							}
							Str_temp += "</table><h>平均成绩"+data.avg+"</h>";
				            $("#div").html(Str_temp); 
							
						}else{
						
							$("#div").hide();
							$("#errorDiv").show();
						}
						jQuery("#form").get(0).reset();
					},
				});
			}
		});
	});
</script>
</head>

<body>
	<div>
	<form method="post" id="form">
		<label for="name">科目：</label>
		<input type="text" name="course.name" id="name" />
		<a id="submit" href="#" class="easyui-linkbutton">查询</a>
	</form>
	</div>
	<br>
	<div id="errorDiv" style="display:none">
		<label>错误</label>
	</div>
	<div id="div" style="display:none"></div>
</body>
</html>