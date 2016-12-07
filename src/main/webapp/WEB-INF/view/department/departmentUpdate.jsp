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
		var dg = parent.$("iframe[title='系别管理']").get(0).contentWindow.$("#dg");
		alert(dg);
		var rows = dg.datagrid("getSelections");
		//将拿到的那一行对应的数据字段加载到表单里，实现回显 
		$("#ff").form('load',{
			did:rows[0].did,
			name:rows[0].name,
		});
		//回显完了数据后，设置一下验证功能
		$("input[name=name]").validatebox({
			required: true,
			missingMessage:'请输入名称'
		});
		
		$("input[name = did]").numberbox({
			required:true,
			missingMessage:'请输入编号',
		});
		//窗体弹出默认时禁用验证
		$("#ff").form("disableValidation");
		//注册button的事件 
		$("#btn").click(function(){
			$("#ff").form("enableValidation");
			if($("#ff").form("validate")){
				$("#ff").form('submit',{
					url:'departmentUpdate',
					success:function(){
						parent.$("#win").window("close");
						dg.datagrid("reload");
					}
				});
			}
		});
	});
	</script>
	</head>
	
	<body>
		<form title="更新商品" id="ff" method="post" >
			<div>
				<label for="did">系别编号：</label>
				<input type="text" name="did" id="did" disabled="disabled"/>
			</div>
			<div>
				<label for="name">系别名字：</label>
				<input type="text" name="name" id="name" />
			</div>
			
			<div>
				<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">更新</a>
			</div>
		</form>
	</body>
</html>


