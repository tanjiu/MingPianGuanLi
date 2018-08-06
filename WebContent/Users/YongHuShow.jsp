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
<title>用户名片详情</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath }/js/jquery-1.10.2.min.js"></script>
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
	//取消
	function Cancle() {
		if (top.topManager) {
			top.topManager.closePage();
		}
	}

	function Modify() {
		//用window.location.href传值
		var id = $("#bh").val();
		window.location.href = "${pageContext.request.contextPath}/CSHModel?id="
				+ id;
	}
</script>
</head>
<body>
	<form>
		<%!MingPianModel model = new MingPianModel();
			MingPianModel models=new MingPianModel();
		%>
		<%
			models = (MingPianModel) request.getAttribute("yonghumodel");
			if(models!=null){
				model=models;
			}
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
								<td>
									<p><%=model.getXingMing() != null ? model.getXingMing() : ""%></p>
								</td>
								<td><input type="hidden" value="<%=model.getBianHao()%>"
									id="bh" /></td>
							</tr>
							<tr style="height: 25px; color: #000; margin-top: 5px;">
								<td>
									<p>职务:</p>
								</td>
								<td>
									<p><%=model.getZhiWu() != null ? model.getZhiWu() : ""%></p>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<div style="width: 100%; margin-top: 20px;">
					<table style="margin-left: 40px;">
						<tr style="height: 25px; margin-left: 40px;">
							<td style="width: 100px;">
								<p>联系方式:</p>
							</td>
							<td>
								<p><%=model.getLianXiFangShi() != null ? model.getLianXiFangShi() : ""%></p>
							</td>
							<td style="width: 60px;">
								<p>邮箱:</p>
							</td>
							<td>
								<p><%=model.getYouXiang() != null ? model.getYouXiang() : ""%></p>
							</td>
						</tr>
						<!-- 						<tr -->
						<!-- 							style="float: left; width: 250px; height: 25px; margin-left: 15px;"> -->

						<!-- 						</tr> -->
						<tr style="height: 25px; margin-left: 40px; margin-top: 5px;">
							<td style="width: 100px;">
								<p>工作单位:</p>
							</td>
							<td colspan="3">
								<p style="width: 380px;"><%=model.getGongZuoDanWei() != null ? model.getGongZuoDanWei() : ""%></p>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div style="text-align: center; margin-top: 15px;">

				<input type="button" value="确定" class="btnclass" onclick="Cancle()" />
				<input type="button" value="编辑" class="btnclass" onclick="Modify()" />
			</div>
		</div>
	</form>
</body>
</html>