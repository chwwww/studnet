<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="/public/head.jspf" %>
		<style type="text/css">
			form div {
				margin: 5px;
			}
		</style>
		<script type="text/javascript">
			$(function(){
				$("input[name=cid]").validatebox({
					required:true,
					missingMessage:'请输入类别编号'//提示的内容
				});
				$("input[name=name]").validatebox({
					required:true,
					missingMessage:'请输入名字'
				});				
				//窗体弹出默认是禁用验证，因为刚弹出的窗口，用户还没填就显示的话，太丑
				$("#ff").form("disableValidation");
				//注册button的事件。即当用户点击“添加”的时候做的事
				$("#btn").click(function(){
					//开启验证
					$("#ff").form("enableValidation");
					//如果验证成功，则提交数据
					if($("#ff").form("validate") /* && $("#cc").form("validate") */){
					//调用submit方法提交数据
						$("#ff").form('submit',{
							url:'sendCourseSave',
							success:function(){//成功后
								//关闭窗口
								parent.$("#win").window("close");
								//刷新页面
								 parent.$("iframe[title='课程管理']").get(0).contentWindow.$("#dg").datagrid("reload"); 
							}
						});												
					}
				});
			});
		</script>
	</head>
	<body>
		<form id="ff" method="post">
			<div>
				<label for="cid">课程编号：</label>
				<input type="text" name="cid" id="cid" />
			</div>
			<div>
				<label for="name">课程名字：</label>
				<input type="text" name="name" id="name" />
			</div>
			<div>
				<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
			</div>
		</form>
	</body>
</html>
