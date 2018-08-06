<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>


<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>修改密码</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>

	<!-- Top content -->

	<div class="col-sm-6 col-sm-offset-3 form-box"
		style="margin-top: 150px;">
		<div class="form-bottom">
			<form role="form" action="" method="post" class="login-form">
				<div class="form-group">
					<label class="sr-only" for="form-username">账号</label> <input
						type="password" name="form-username" placeholder="请输入旧密码"
						class="form-username form-control" id="form-username">
				</div>
				<div class="form-group">
					<label class="sr-only" for="form-password">密码</label> <input
						type="password" name="form-password" placeholder="请输入新密码"
						class="form-password form-control" id="form-password">
				</div>
				<div class="form-group">
					<label class="sr-only" for="form-password">确认密码</label> <input
						type="password" name="form-password" placeholder="请确认新密码"
						class="form-password form-control" id="form-password1">
				</div>
				<button type="button" class="btn" onclick="xiugaimima()">修改密码</button>
			</form>
		</div>
	</div>





	<!--信息提示框-->
	<div class="modal fade" id="tishi" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabe2">
		<div class="modal-dialog" role="document"
			style="width: 300px; height: 195px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabe2">提示</h4>
				</div>
				<div class="modal-body">
					<p id="tsxinxi">请至少选择一项！</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal"
						id="btnclick">确认</button>
				</div>
			</div>
		</div>
	</div>
	<!--信息提示框结束-->


	<!-- Javascript -->
	<script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<!-- 	<script src="assets/js/jquery.backstretch.min.js"></script> -->
	<script src="assets/js/scripts.js"></script>
	<script src="${pageContext.request.contextPath }/js/TanChuKuang.js"></script>
	<script type="text/javascript">
		function xiugaimima() {
			var zhanghao = $("#form-username").val();
			var mima1 = $("#form-password").val();
			var mima2 = $("#form-password1").val();
			if (zhanghao.length == 0) {
				$("#tsxinxi").text("旧密码不能为空！");
				$("#tishi").modal();
			} else if (mima1 != mima2) {
				$("#tsxinxi").text("两次密码不一致！");
				$("#tishi").modal();
			} else if (zhanghao == mima1) {
				$("#tsxinxi").text("新密码不能与旧密码相同！");
				$("#tishi").modal();
			} else {
				var data = $("form").serializeArray();
				$.getJSON("${pageContext.request.contextPath}/XiuGaiMiMa",
						data, function(data) {
							//alert(data);
							//根据信息反馈注册情况
							var zhanghao = $("#form-username").val("");
							var mima1 = $("#form-password").val("");
							var mima2 = $("#form-password1").val("");
							if (data[0] == "500") {
								$("#tsxinxi").text("修改密码失败！");
								$("#tishi").modal();
							} else if (data[0] == "200") {
								$("#tsxinxi").text("修改密码成功！");
								$("#tishi").modal();
								//只在修改成功时对确定按钮进行监视
								$("#btnclick").click(function() {
									if (top.topManager) {
										top.topManager.openPage({
											id : 'code',
											isClose : true
										});
									}
								});
							} else if (data[0] == "404") {
								$("#tsxinxi").text("旧密码错误！");
								$("#tishi").modal();
							}
						});
			}

		}
	</script>
	<!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

</body>

</html>