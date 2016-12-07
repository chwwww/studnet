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
		$('#dg').datagrid({
			url : 'queryCourseByName',

			loadMsg : 'Loading....', //表示加载数据过程中显示的信息

			queryParams : {
				'courseCustom.name' : ''
			}, //这里参数改成name，参数值为空，表示我们要显示所有商品，后台是根据商品name属性查询的

			fitColumns : true, //设置为true后表示水平自动展开，自适应网格的宽度，如此设置，水平方向就不会有滚动条了，也不用设置宽度了

			striped : true, //是宽度，如果数据过长显示不下，水平方向就会出现滚动条

			nowrap : true, //如果为true，则在同一行中显示数据。设置为true可以提高加载性能。设置为true后表示当数据多的时候不换行，否则某一行数据多的时候会换行，会比较难看

			singleSelect : false, //设置为true时，只允许勾选单行，全选功能失效，主要用于最前面一列的复选框

			pageSize : 5, //默认10

			pageList : [ 5, 10, 15, 20 ], ////设置可选的每页记录数，供用户选择，默认是10,20,30,40...

			idField : 'cid', //指定id为标识字段，在删除，更新的时候有用，如果配置此字段，在翻页时，换页不会影响选中的项 

			pagination : true, //设置为true后表示开启分页功能

			toolbar : [ {
				iconCls : 'icon-add',
				text : '添加课程',
				handler : function() {
					parent.$("#win").window({
						title:"添加系别",
						width:650,
						height:600,
						content:'<iframe src="course/sendCourseSaveJsp" frameborder="0" width="100%" height="100%" />'
					});
				}
			}, '-', {
				iconCls : 'icon-edit',
				text : ' 更新课程',
				handler : function() {
					//判断是否有选中行记录，使用getSelections获取选中的所有行 
							var rows = $("#dg").datagrid("getSelections");
							if(rows.length == 0){
								$.messager.show({
									title:'错误提示',
									msg:'至少要选择一条记录',
									timeout:2000,
									showType:'slide'
								});
							} else if(rows.length != 1){
								$.messager.show({
									title:'错误提示',
									msg:'每次只能更新一条记录',
									timeout:2000,
									showType:'slide'
								});
							} else {
								parent.$("#win").window({
									title:'更新系别',
									width:650,
									height:600,
									content:'<iframe src="course/sendCourseUpdate" frameborder="0" width="100%" height="100%" />'
								});
							}
				}
			}, '-', {
				iconCls : 'icon-remove',
				text : '删除课程',
				handler : function() {
					var rows = $("#dg").datagrid("getSelections");
					if (rows.length == 0) {
						$.messager.show({
							title : '错误提示',
							msg : '至少要选择一条记录',
							timeout : 2000,
							showType : 'slide',
						});
					} else {
						$.messager.confirm("删除的确认对话框", "您确定要删除此项吗？", function(r) {
							if (r) {
								var ids = "";
								for (var i = 0; i < rows.length; i++) {
									ids += rows[i].cid + ",";
								}
								ids = ids.substr(0, ids.lastIndexOf(","));
								$.post("courseDeleteByIds",{ cids : ids},
									function (data) {
                                    var result=data.result;
                                    alert(result);
										if (result == "true") {
											$("#dg").datagrid("uncheckAll");
											$("#dg").datagrid("reload");
										} else {
											$.messager.show({
												title : '删除异常',
												msg : '删除失败',
												timeout : 2000,
												showType : 'slide',
											});
									}
								}, 'json');
							}
						});
					}
				}
			}, '-', { //查询按钮不是LinkButton，它有语法，但是也支持解析HTML标签
				text : "<input id='ss',name='serach' />"
			} ],

			rowStyler : function(index, row) {
				console.info("index" + index + "," + row)
				if (index % 2 == 0) {
					return 'background-color:#fff;';
				} else {
					return 'background-color:#c4e1e1;';
				}
			}, //是设置所有行的样式的，两个参数为行索引和行，上面设置的是偶数行是白色，奇数行是黄色。

			frozenColumns : [ [
				{
					field : 'checkbox',
					checkbox : true
				},
				{
					field : 'cid',
					title : '课程编号',
					width : 100
				}
			] ], //是为了设置冻结列，在frozenColums中设置的列，不会改变大小。里面如果设置了{field:'checkbox',checkbox:true},表示这是个复选框列，给用户勾选用的，如果设置了上面的singleSelect，那么只能选择一项，不能全选；

			columns : [ [
				{
					field : 'name',
					title : '课程名称',
					width : 100
				}
		
			] ]
		});
		$('#ss').searchbox({
			//触发查询事件  
			searcher : function(value, name) { //value表示输入的值  
				$('#dg').datagrid('load', {
					'departmentCustom.name': value
				}) //查询操作  
			},
			prompt : '请输入搜索关键字' //默认的显示  
		})
	});
</script>
</head>

<body>
	<table id="dg"></table>
</body>
</html>