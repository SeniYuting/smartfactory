<%@ page import="java.util.ArrayList"%>
<%@ page import="model.SourceData"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>SmartFactory</title>

<%
	String path = request.getContextPath();
%>
<link href="<%=path%>/admin/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/admin/css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="<%=path%>/admin/css/dataTables.responsive.css"
	rel="stylesheet">
<link href="<%=path%>/admin/css/admin.css" rel="stylesheet">
<link href="<%=path%>/admin/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
</head>

<body>
	<%
		ArrayList<SourceData> dataList = new ArrayList<SourceData>();
		if (request.getAttribute("dataList") != null) {
			dataList = (ArrayList<SourceData>) request.getAttribute("dataList");
		}
	%>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">

		<div class="navbar-header">
			<a class="navbar-brand" href="#">SmartFactory</a>
		</div>

		<ul class="nav navbar-top-links navbar-right">
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user" style="min-width: 110px">
					<li><a href="admin/login.jsp"><i
							class="fa fa-sign-out fa-fw"></i> 注销</a></li>
				</ul></li>
			<!-- /.dropdown -->
		</ul>

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li><a href="<%=path%>/SourceDataServlet" class="active"><i
							class="fa fa-dashboard fa-fw"></i> SourceData</a></li>
					<li><a href="<%=path%>/GoalDataServlet"><i
							class="fa fa-table fa-fw"></i> GoalData</a></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">SourceData</h1>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							mongodb中的源数据
							<button class="btn btn-default" type="button" id="add">
								<i class="fa fa-plus"></i>
							</button>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="dataTable_wrapper" style="overflow: auto;">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables">
									<thead>
										<tr>
											<th>Name</th>
											<th>Type</th>
											<th>TupleNum</th>
											<th>Frequency</th>
											<th>Source</th>
											<th>SQL</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < dataList.size(); i++) {
										%>
										<tr>
											<td width="15%" style="word-break: break-all"><span name="source_item"><%=dataList.get(i).getName()%></span></td>
											<td width="8%"><%=dataList.get(i).getType()%></td>
											<td width="10%"><%=dataList.get(i).getTupleNum()%></td>
											<td width="10%"><%=dataList.get(i).getFrequency()%></td>
											<td width="10%"><%=dataList.get(i).getSource()%></td>
											<td width="37%"><%=dataList.get(i).getSql()%></td>
											<td width="10%">
												<button class="btn btn-default delete" type="submit"
													data-id="<%=dataList.get(i).get_id()%>">
													<i class="fa fa-trash"></i>
												</button>
												<button class="btn btn-default edit" type="button"
													data-id="<%=dataList.get(i).get_id()%>"
													data-name="<%=dataList.get(i).getName()%>"
													data-type="<%=dataList.get(i).getType()%>"
													data-tuplenum="<%=dataList.get(i).getTupleNum()%>"
													data-frequency="<%=dataList.get(i).getFrequency()%>"
													data-source="<%=dataList.get(i).getSource()%>"
													data-sql="<%=dataList.get(i).getSql()%>">
													<i class="fa fa-edit"></i>
												</button>
											</td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

	<div class="modal fade" id="modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form role="form" method='POST' action='/' id="form">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="modalTitle"></h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-lg-12">
								<div class="form-group">
									<label>Name</label> <input class="form-control" name="name">
								</div>
								<div class="col-lg-4" style="padding-left: 0;">
									<div class="form-group">
										<label>Type</label> <select class="form-control" name="type">
											<option>single</option>
											<option>list</option>
										</select>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="form-group">
										<label>TupleNum</label> <input class="form-control"
											name="tupleNum" type="number" min="1"
											onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
											onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}">
									</div>
								</div>
								<div class="col-lg-4" style="padding-right: 0;">
									<div class="form-group">
										<label>Frequency</label> <input class="form-control"
											name="frequency">
									</div>
								</div>
								<div class="form-group">
									<label>Source</label>
									<textarea class="form-control" rows="4" name="source"></textarea>
								</div>
								<div class="form-group">
									<label>SQL</label>
									<textarea class="form-control" rows="4" name="sql"></textarea>
								</div>

								<div class="form-group">
									<label id="alert" style="color: red;"></label>
								</div>

							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" id="save"
							data-path="<%=path%>" data-id="">保存</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script src="<%=path%>/admin/js/jquery.min.js"></script>
	<script src="<%=path%>/admin/js/bootstrap.min.js"></script>
	<script src="<%=path%>/admin/js/jquery.dataTables.min.js"></script>
	<script src="<%=path%>/admin/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=path%>/admin/js/admin.js"></script>
	<script src="<%=path%>/admin/js/bootbox.min.js"></script>

	<script src="<%=path%>/admin/js/sourceData.js"></script>

	<script>
		$(document).ready(function() {
			$('#dataTables').DataTable({
				responsive : true,
				oLanguage : {
					"sLengthMenu" : "每页显示 _MENU_ 条记录",
					"sZeroRecords" : "对不起，查询不到任何相关数据",
					"sInfo" : "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
					"sInfoEmtpy" : "找不到相关数据",
					"sInfoFiltered" : "数据表中共为 _MAX_ 条记录)",
					"sProcessing" : "正在加载中...",
					"sSearch" : "搜索",
					"sUrl" : "", //多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
					"oPaginate" : {
						"sFirst" : "第一页",
						"sPrevious" : " 上一页 ",
						"sNext" : " 下一页 ",
						"sLast" : " 最后一页 "
					}
				}
			});
		});
	</script>

</body>

</html>
