<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/public/head.jspf"%>

<title>学生成绩录入</title>
<script type="text/javascript">
	$(function() {
		/*先 验证 */
		$('#name').validatebox({
			required : true,
			missingMessage : '请输入姓名'
		});
		
		$('#sid').validatebox({
			required : true,
			missingMessage : '请输入学号'
		});
		
		$("#cc").combobox({
					 //将请求发送给categoryAction中的query方法处理，这里需要将处理好的数据返回到这边来显示了 ，所以后台需要将数据打包成json格式发过来
					 url:'courseQuery',
					 valueField:'cid',
					 textField:'name',//我们下拉列表中显示的是所有的商品类别 
					 panelHeight:'auto',//自适应高度
					 panelWidth:120,
					 width:120,//下拉列表是由两个组件组成，故需设置两个宽度
					 editable:false,//下拉框不允许编辑
					 //combobox继承combo继承validatebox，所以可以直接在这里设置验证
					 required:true,
					 missingMessage:'请选择科目'
				});
		
		
		/* $('#course').validatebox({
			required : true,
			missingMessage : '请输入学科'
		}); */
		/* 100|[1-9]\d|0 */
		$.extend($.fn.validatebox.defaults.rules, {
			grade : {
				validator : function(value) {
					var reg = /^(100|[1-9]\d|\d)$/;
					return reg.test(value);
				},
				message : '请输入0到100的数字'
			}
		});

		$("#ff").form("disableValidation");

		$("#reset").click(function(){
					$("#ff").form("disableValidation");//重置不需要表单验证
					//重置当前表单数据
					$("#ff").form("reset");
				});
		
		/* 表单提交时间 */
		$("#submit").click(function() {
			$("#ff").form("enableValidation");
			if ($("#ff").form("validate")) {
				$("#ff").form('submit', {
					url :'saveStudnetGrade',
					success : function(data) {
						var data = eval('(' + data + ')');
						alert(data.result);
						jQuery("#ff").get(0).reset();
					},
				});
			}
		});
	});
</script>


</head>

<body>

	<form id="ff" method="post">
		<div>
			<label for="name">姓名：</label> <input type="text" id="name"
				name="student.name" />
		</div>
		<div>
			<label for="sid">学号：</label> <input type="text" id="sid"
				name="student.sid" />
		</div>
		<div>
			<label for="course">学科：</label> 
			<input id="cc" name=course.cid />
		</div>
		<div>
			<label for="grade">成绩：</label> <input type="text" name="grade"
				class="easyui-validatebox" data-options="validType:'grade'" />
		</div>

		<div>
			<a id="submit" href="#" class="easyui-linkbutton">添加</a> <a
				id="reset" href="#" class="easyui-linkbutton">重置</a>
		</div>
	</form>

</body>
</html>
