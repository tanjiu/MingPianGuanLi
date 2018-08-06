<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>


<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户登陆</title>

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
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1>
							<strong>农大学子</strong>
						</h1>
						<div class="description">
							<p>
								这是我的大作业，欢迎体验！ Made By <a href="#"><strong>Shao Ming
										jun</strong></a>, customize and use it as you like!
							</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<h3>名片管理系统</h3>
								<p>请输入账号和密码:</p>
							</div>
							<div class="form-top-right">
								<i class="fa fa-key"></i>
							</div>
						</div>
						<div class="form-bottom">
							<form role="form" action="" method="post" class="login-form">
								<div class="form-group">
									<label class="sr-only" for="form-username">账号</label> <input
										type="text" name="form-username" placeholder="请输入账号"
										class="form-username form-control" id="form-username">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-password">密码</label> <input
										type="password" name="form-password" placeholder="请输入密码"
										class="form-password form-control" id="form-password">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-password"> 请输入验证码：</label> <input
										type="text" name="code" style="width: 80px; height: 30px;" />
									<img id="imgObj" alt="验证码"
										src="${pageContext.request.contextPath}/getCode"><a
										href="#" onclick="changeImg()">换一张</a> <a
										href="/test2/Users/YongHuZhuCe.jsp" style="margin-left: 20px;">注册账号</a>
									<a href="/test2/Users/Login.jsp" style="margin-left: 20px;">管理员登陆入口</a>
									<p style="display: none; color: red;" id='yzm'>验证码不正确！</p>
								</div>
								<button type="button" class="btn" onclick="dengLu()">登陆</button>
							</form>
						</div>
					</div>
				</div>

			</div>
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
	<script src="assets/js/jquery.backstretch.min.js"></script>
	<script src="assets/js/scripts.js"></script>
	<script type="text/javascript">
		$(function() {

		});

		function changeImg() {
			var imgSrc = $("#imgObj");
			var src = imgSrc.attr("src");
			imgSrc.attr("src", chgUrl(src));
		}

		// 时间戳
		// 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
		function chgUrl(url) {
			var timestamp = (new Date()).valueOf();
			url = url.substring(0, 20);
			if ((url.indexOf("&") >= 0)) {
				url = url + "×tamp=" + timestamp;
			} else {
				url = url + "?timestamp=" + timestamp;
			}
			return url;
		}

		function dengLu() {
			var data = $("form").serializeArray();
			$.getJSON("${pageContext.request.contextPath}/YongHuDengLu", data,
					function(data) {
						//alert(data);
						//根据信息反馈登陆情况
						if (data[0] == "500") {
							//alert("500");
							$("#yzm").css("display", "");
						} else if (data[0] == "404") {
							$("#tsxinxi").text("账号或密码错误!");
							$("#tishi").modal();
						} else if (data[0] == "200") {
							//alert("200");
							//登陆到用户个人页面							
							window.location.href = "/test2/Users/YongHuDaoHang.jsp";
							//window.event.returnValue=false;
						}

					});
		}
	</script>
	<!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

</body>

</html>