<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加名片</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath }/js/jquery-1.10.2.min.js"></script>
<script
	src="${pageContext.request.contextPath }/js/vendor/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/js/TanChuKuang.js"></script>
<style type="text/css">
p {
	color: #FFFFFF;
}

.btnclass {
	background-color: #3DB8FE;
	width: 70px;
	color: #fff;
	border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
	text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
	cursor: pointer;
	border-radius: 3px;
}
</style>
<script>
	function btnSave() {
		var data = $("form").serializeArray();
		console.log(data);
		var xm = $("#xm").val();
		if (xm != "") {
			$.post("../../test2/Add", data, function(data) {
				if (data != null) {
					top.topManager.reloadPage('code');
					top.topManager.closePage();
				} else {
					$("#tsxinxi").text("添加失败！");
					$("#tishi").modal();
					top.topManager.closePage();
				}
			});
		} else {
			$("#tsxinxi").text("姓名不能为空！");
			$("#tishi").modal();
		}

	}

	//取消
	function Cancle() {
		top.topManager.closePage();
	}
</script>
</head>
<body>
	<form>
		<div
			style="width: 100%; border: 1px solid #3DB8FE; margin-top: 100px; overflow: hidden;">
			<div
				style="margin: 1px auto; border: 1px solid #3DB8FE; width: 600px; height: 310px; background-color: #3DB8FE;">
				<div
					style="width: 100%; height: 100px; background-color: #AB82FF; margin-top: 100px;">
					<div style="height: 10px;"></div>
					<div
						style="margin: auto auto; width: 300px; height: 95px; margin-top: 5px;">
						<table style="margin-top: 15px;" id="tb">
							<tr style="height: 25px; color: #000;">
								<td>
									<p>姓名:</p>
								</td>
								<td><input type="text" name="xm" placeholder="请输入姓名"
									id="xm" /></td>

							</tr>
							<tr style="height: 25px; color: #000; margin-top: 5px;">
								<td>
									<p>职务:</p>
								</td>
								<td><input type="text" name="zw" placeholder="请输入职务" /></td>
							</tr>
						</table>
					</div>
				</div>
				<div style="width: 100%; margin-top: 20px;">
					<table style="margin: auto atuo;">
						<tr style="float: left; height: 25px; margin-left: 40px;">
							<td style="width: 100px;">
								<p>联系方式:</p>
							</td>
							<td><input type="text" name="lxfs" placeholder="请输入联系方方式" /></td>
						</tr>
						<tr
							style="float: left; width: 250px; height: 25px; margin-left: 15px;">
							<td style="width: 60px;">
								<p>邮箱:</p>
							</td>
							<td><input type="text" name="yx" placeholder="请输入邮箱" /></td>
						</tr>
						<tr
							style="float: left; height: 25px; margin-left: 40px; margin-top: 5px;">
							<td style="width: 100px;">
								<p>工作单位:</p>
							</td>
							<td><input type="text" name="gzdw" placeholder="请输入工作单位"
								style="width: 380px;" /></td>
						</tr>
					</table>
				</div>
			</div>
			<div style="text-align: center; margin-top: 15px;">
				<input type="button" value="保存" class="btnclass" onclick="btnSave()" />
				<input type="button" value="取消" class="btnclass" onclick="Cancle()" />
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
						<p id="tsxinxi" style="color:black;">请至少选择一项！</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success" data-dismiss="modal"
							id="btnclick">确认</button>
					</div>
				</div>
			</div>
		</div>
		<!--信息提示框结束-->
	</form>
</body>
</html>