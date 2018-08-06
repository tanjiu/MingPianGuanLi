<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="vo.MingPianModel" import=" java.util.*"%>
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
<title>名片列表</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<link href="${pageContext.request.contextPath }/css/pagination.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath }/css/ZiJia.css"
	rel="stylesheet" />

<script
	src="${pageContext.request.contextPath }/js/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath }/js/TanChuKuang.js"></script>


<script>
	function show(e) {
		var id = $(e).parents("td").parents("tr").children()[1].innerHTML;
		console.log(id);
		if (top.topManager) {
			top.topManager.openPage({
				id : 'bmshow',
				href : "../../test2/XiangQing?id=" + id,//iframe的url 
				title : '名片信息详情'
			});
		}

	}
	function modify(e) {
		var id = $(e).parents("td").parents("tr").children()[1].innerHTML;
		//alert(id);
		if (top.topManager) {
			top.topManager.openPage({
				id : 'mpmodify',
				href : "../../test2/CSHModel?id=" + id,//iframe的url 
				title : '名片信息编辑'
			});
		}

	}

	function addChuang() {
		if (top.topManager) {
			top.topManager.openPage({
				id : 'mpadd',
				href : 'Add.jsp',
				title : '添加名片信息'
			});
		}
	}
	//************************************************************************
	function DeleteList() {
		var checkNum = $("input[name='checkone']:checked").length;
		if (checkNum == 0) {
			$("#tsxinxi").text("请至少选择一项！");
			$("#tishi").modal();
			return;
		}
		Ewin.confirm({
			message : "确认要删除选择的数据吗？"
		}).on(function(e) {
			if (!e) {
				return;
			}
			var ids = [];
			$("input[name='checkone']:checked").each(function() {
				var bianma = $(this).val();
				ids.push(bianma);
			});
			//alert(ids);
			$.getJSON("ShanChu", {
				shanchu : "shanchu",
				ids : ids.toString()
			}, function(data) {
				if (data[0] === "ok")
					if (top.topManager) {
						top.topManager.reloadPage();
					}
			});
		});
	}

	//删除一条
	function Delete(e) {
		var id = $(e).parents("td").parents("tr").children()[1].innerHTML;
		//alert(id);
		var msg = "您真的确定要删除吗？\n\n请确认！";
		Ewin.confirm({
			message : "确认要删除选择的数据吗？"
		}).on(function(e) {
			if (!e) {
				return;
			}
			$.getJSON("ShanChu", {
				id : id,
				action : "deletes"
			}, function(data) {
				if (data[0] === "ok")//刷新会跳转到列表页面，需要修改
					if (top.topManager) {
						top.topManager.reloadPage();
					}
			});
		});
	}
</script>

</head>
<body>
	<div id="main-container">
		<div id="page-content">
			<div>
				<a onclick="addChuang()" class="btn btn-default">添加信息</a> <a
					onclick="DeleteList()" class="btn btn-default">批量删除</a>
			</div>


			<div class="table-responsive" style="overflow: hidden;">
				<!--响应式样式-->
				<table
					class="table table-striped table-bordered table-bordered table-bordered"
					id="biaogeneirong">
					<thead>
						<tr>
							<th style="width: 30px;"><input type="checkbox" id="checks" /></th>
							<th>编号</th>
							<th>姓名</th>
							<th>职务</th>
							<th>联系方式</th>
							<th>邮箱</th>
							<th>工作单位</th>
							<th>操作</th>

						</tr>
					</thead>
					<tbody id="id_contacts_data">
						<%!List<MingPianModel> list = new ArrayList<MingPianModel>();%>
						<%
							list = (List<MingPianModel>) request.getAttribute("list");
						%>
						<%
							for (int i = 0; i < list.size(); i++) {
						%>
						<tr>
							<td><input type='checkbox'
								value="<%=list.get(i).getBianHao()%>" name='checkone'
								class='checkone'></td>
							<td><%=list.get(i).getBianHao()%></td>
							<td><%=list.get(i).getXingMing()%></td>
							<td><%=list.get(i).getZhiWu()%></td>
							<td><%=list.get(i).getLianXiFangShi()%></td>
							<td><%=list.get(i).getYouXiang()%></td>
							<td><%=list.get(i).getGongZuoDanWei()%></td>
							<td><span> <a href='javascript:void(0)'
									onclick='modify(this)'> 编辑</a></span> <span><a
									href='javascript:void(0)' onclick='show(this)'> 详情</a></span> <span><a
									href='javascript:void(0)' onclick='Delete(this)'> 删除</a></span></td>
						</tr>
						<%
							}
						%>



					</tbody>
				</table>
				<div id="page" style="margin: 15px -2px; float: right;"></div>
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



	<script
		src="${pageContext.request.contextPath }/js/vendor/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/plugins.js"></script>
	<script src="${pageContext.request.contextPath }/js/tool.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bui-min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/config-min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/slider-min.js"></script>
	<script>
		$(function() {

			$("#biaogeneirong tbody tr").mouseover(function() {
				$(this).addClass("success");
			}).mouseout(function() {
				$(this).removeClass("success");
			});

			$("#checks").click(function() {
				var value = $(this).prop("checked");
				$(".checkone").prop("checked", value);
			});
		});
	</script>
</body>
</html>