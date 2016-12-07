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
			missingMessage : '请输入姓名'
		});
		
		$('#sid').validatebox({
			required : true,
			missingMessage : '请输入学号'
		});
		$("#form").form("disableValidation");
		$("#submit").click(function() {
			$("#form").form("enableValidation");
			if ($("#form").form("validate")) {
				$("#form").form('submit', {
					url :'queryStudentGrade',
					success : function(data) {
						var data = eval('(' + data + ')');
						if (data.result == "true") {
							$("#div").show();
							$("#errorDiv").hide();
							var gradeKey = "";
							var obj = data.courseName;
							for(var i=0;i<obj.length;i++){
								gradeKey+= "<th>";
								gradeKey+=obj[i]; 
								gradeKey+= "</th>";
							}
							var Str_temp = "<table><tr><th>name</th>"+gradeKey+"<th> 平均分</th><th>总分</th></tr>";
				            var gradeValue = "";
				            obj =data.courseGrade;
				            for(var i=0;i<obj.length;i++){
								gradeValue+= "<th>";
								gradeValue+=obj[i]; 
								gradeValue+= "</th>";
							}
				             Str_temp += "<tr><td>" + data.name + "</td>" + gradeValue + "<td>"+data.avgGrade +"</td><td>" + data.totalGrade + "</td></tr></table>";
				            $("#div").html(Str_temp);
							
						}else{
							$("#errorDiv").show();
							$("#div").hide();
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
		<label for="sid">学号：</label>
		<input type="text" name="student.sid" id="sid" />
		<label for="name">姓名：</label>
		<input type="text" name="student.name" id="name" />
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