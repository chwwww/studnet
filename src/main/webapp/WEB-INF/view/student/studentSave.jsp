<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="/public/head.jspf" %>
		<style type="text/css">
			form div {
				margin: 10px;
			}
		</style>
		<script type="text/javascript">
			$(function(){
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
				$("#submit").click(function(){
					//开启验证
					$("#ff").form("enableValidation");
					//如果验证成功则提交数据
					if($("#ff").form("validate")){
						//调用submit方法提交数据
						$("#ff").form('submit',{
							url:'studentSave',
							success:function(){
								//如果成功关闭窗口
								parent.$("#win").window("close");
								parent.$("iframe[title='学生管理']").get(0).contentWindow.$("#dg").datagrid("reload");
							}
						});
					}
				});
				//注册button事件
				$("#reset").click(function(){
					$("#ff").form("disableValidation");//重置不需要表单验证
					//重置当前表单数据
					$("#ff").form("reset");
				});
			});
		</script>
	</head>
	<body>
		<form title="添加商品" id="ff" method="post" >
			<div>
				<label for="name">姓名：</label>
				<input type="text" name="name" id="name" />
			</div>
			
			<div>
				<label >性别：</label>
				男<input type="radio" name="sex" checked="checked" value="男" />
				女<input type="radio" name="sex" value="女" />
			</div>
			
			<div>
				<label for="birthday">出生日期：</label>
				<input id="dd" type="text" name="birthday" id="birthday"/>
			</div>
			
			<div>
				<label>系别:</label>
				<input id="cc" name="department.did" />
			</div>
			
			<div>
				<a id="submit" href="#" class="easyui-linkbutton">添加</a>
				<a id="reset" href="#" class="easyui-linkbutton">重置</a>
			</div>
		</form>
	</body>
</html>


