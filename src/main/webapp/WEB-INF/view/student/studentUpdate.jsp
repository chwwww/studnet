<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
		//iframe中的datagrid对象
		var dg = parent.$("iframe[title='学生管理']").get(0).contentWindow.$("#dg");
		//对管理员的下拉列表框进行远程加载
		$("#cc").combobox({
					 //将请求发送给categoryAction中的query方法处理，这里需要将处理好的数据返回到这边来显示了 ，所以后台需要将数据打包成json格式发过来
					 url:'departmentQuery',
					 valueField:'did',
					 textField:'name',//我们下拉列表中显示的是所有的商品类别 
					 panelHeight:'auto',//自适应高度
					 panelWidth:120,
					 width:120,//下拉列表是由两个组件组成，故需设置两个宽度
					 editable:false,//下拉框不允许编辑
					 //combobox继承combo继承validatebox，所以可以直接在这里设置验证
					 required:true,
					 missingMessage:'请选择所属系别'
				});
		
		var rows = dg.datagrid("getSelections");
		//将拿到的那一行对应的数据字段加载到表单里，实现回显 
		$("#ff").form('load',{
			sid:rows[0].sid,
			name:rows[0].name,
			sex:rows[0].sex,
			date:rows[0].date,
			'department.did':rows[0].department.did
		});
		//回显完了数据后，设置一下验证功能
		$("input[name = name]").validatebox({
					required:true,
					missingMessage:'请输入姓名'
				});
				
				$('#dd').datebox({
    				required:true
				});
		//窗体弹出默认时禁用验证
		$("#ff").form("disableValidation");
		//注册button的事件 
		$("#btn").click(function(){
			$("#ff").form("enableValidation");
			if($("#ff").form("validate")){
				$("#ff").form('submit',{
					url:'studentUpdate',
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
		<form title="更改信息" id="ff" method="post" >
			<div>
				<label for="name">姓名：</label>
				<input type="text" name="name" id="name" readonly="readonly"   />
			</div>
			
			
			<div>
				<label >性别：</label>
				男<input type="radio" name="sex" checked="checked" value="男" />
				女<input type="radio" name="sex" value="女" />
			</div>
			
			<div>
				<label for="date">出生日期：</label>
				<input id="dd" type="text" name="date" id="date"/>
			</div>
			
			<div>
				<label>系别:</label>
				<input id="cc" name="department.did" />
			</div>
			
			<div>
				<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">更新</a>
				<input type="hidden" name="sid"  />
			</div>
		</form>
	</body>
</html>


