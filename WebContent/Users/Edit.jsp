<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>名片编辑</title>
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
	//需要添加是否为空的验证，否则更新报错
	function btnSave() {
		var data = $("form").serializeArray();
		var xm = $("#xm").val();
		if (xm != "") {
			var id = $("#bh").val();
			if (id == "0") {
				//为初次编辑，需要向名片表中插入信息
				$.post("../../test2/Add?action=first", data, function(data) {
					if (data != null) {
						$("#tsxinxi").text("编辑成功！");
						$("#tishi").modal();
						if (top.topManager) {
							top.topManager.reloadPage('code');
							top.topManager.openPage({
								id : 'code',
								isClose : false
							});
						}
					} else {
						$("#tsxinxi").text("编辑失败！");
						$("#tishi").modal();
						if (top.topManager) {
							top.topManager.openPage({
								id : 'code',
								isClose : false
							});
						}
					}
				});
			} else {
				//对信息进行修改，为更新
				$.post("../../test2/Update", data, function(data) {
					if (data != null) {
						if (top.topManager) {
							top.topManager.reloadPage('code');
							top.topManager.openPage({
								id : 'code',
								isClose : true
							});
						}
					} else {
						$("#tsxinxi").text("修改失败！");
						$("#tishi").modal();
						if (top.topManager) {
							top.topManager.openPage({
								id : 'code',
								isClose : true
							});
						}
					}
				});
			}
		} else {
			$("#tsxinxi").text("姓名不能为空！");
			$("#tishi").modal();
		}
	}
	//取消
	function Cancle() {
		if (top.topManager)
			top.topManager.closePage();
	}
</script>
</head>
<body>
	<form>
		<%!MingPianModel model = new MingPianModel();%>
		<%
			model = (MingPianModel) request.getAttribute("model");
		%>

		<div
			style="width: 100%; border: 1px solid #3DB8FE; margin-top: 100px;">
			<div
				style="margin: 1px auto; border: 1px solid #3DB8FE; width: 600px; height: 310px; background-color: #3DB8FE;">
				<div
					style="width: 100%; height: 100px; background-color: #AB82FF; margin-top: 100px;">
					<div style="height: 10px;"></div>
					<div
						style="margin: auto auto; width: 300px; height: 95px; margin-top: 5px;">
						<table style="margin-top: 15px;">
							<tr style="height: 25px; color: #000;">
								<td>
									<p>姓名:</p>
								</td>
								<td><input type="text" id="xm"
									value="<%=model.getXingMing() != null ? model.getXingMing() : ""%>"
									name="xm" /></td>
								<td><input type="hidden" id="bh"
									value="<%=model.getBianHao()%>" name="bh" /></td>
							</tr>
							<tr style="height: 25px; color: #000; margin-top: 5px;">
								<td>
									<p>职务:</p>
								</td>
								<td><input type="text" id="zw"
									value="<%=model.getZhiWu() != null ? model.getZhiWu() : ""%>"
									name="zw" /></td>
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
							<td><input type="text" id="lxfs"
								value="<%=model.getLianXiFangShi() != null ? model.getLianXiFangShi() : ""%>"
								name="lxfs" /></td>
						</tr>
						<tr
							style="float: left; width: 250px; height: 25px; margin-left: 15px;">
							<td style="width: 60px;">
								<p>邮箱:</p>
							</td>
							<td><input type="text" id="yx"
								value="<%=model.getYouXiang() != null ? model.getYouXiang() : ""%>"
								name="yx" /></td>
						</tr>
						<tr
							style="float: left; height: 25px; margin-left: 40px; margin-top: 5px;">
							<td style="width: 100px;">
								<p>工作单位:</p>
							</td>
							<td><input type="text" id="gzdw" style="width: 380px;"
								value="<%=model.getGongZuoDanWei() != null ? model.getGongZuoDanWei() : ""%>"
								name="gzdw" /></td>
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