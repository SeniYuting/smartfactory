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
<link href="<%=path%>/admin/css/admin.css" rel="stylesheet">
<link href="<%=path%>/admin/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<h1 class="logo_title">SmartFactory<br/>配置管理平台</h1>
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">请输入邮箱和密码</h3>
					</div>
					<div class="panel-body">
						<form role="form">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Email" name="email"
										type="email" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										name="password" type="password" value="">
								</div>
								<a class="btn btn-lg btn-primary btn-block" id="login">登录</a>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="<%=path%>/admin/js/jquery.min.js"></script>
	<script src="<%=path%>/admin/js/bootstrap.min.js"></script>
	<script src="<%=path%>/admin/js/admin.js"></script>
	<script src="<%=path%>/admin/js/bootbox.min.js"></script>

	<script src="<%=path%>/admin/js/login.js"></script>
</body>

</html>
