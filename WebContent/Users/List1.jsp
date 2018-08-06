<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		top.topManager.openPage({
			id : 'mpadd',
			href : 'Add.jsp',
			title : '添加名片信息'
		});

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
					top.topManager.reloadPage();
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
					onclick="DeleteList()" class="btn btn-default">批量删除</a> <input
					type="text" class="form-control" placeholder="请输入姓名"
					style="margin-top: 15px; width: 160px;" id="sou" /> <input
					type="button" class="btn btn-default" value="搜索" onclick="SouSuo()" />
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
					<tbody id="id_contacts_data"></tbody>
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
		src="${pageContext.request.contextPath }/js/jquery-1.10.2.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/js/vendor/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/plugins.js"></script>
	<script src="${pageContext.request.contextPath }/js/tool.js"></script>
	<script src="${pageContext.request.contextPath }/js/pagination.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bui-min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/config-min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/slider-min.js"></script>
	<script
		src="${pageContext.request.contextPath }/js/TanChuKuang.js"></script>
	<script>
		//分页查询
		$("#page").whjPaging({
			css : 'css-1',
			isResetPage : true,
			callBack : function(currPage, pageSize) {
				getContactsList(currPage, pageSize);
			}
		});

		function getContactsList(currPage, pageSize) {
			$
					.ajax({
						url : 'ChuShiHua',
						type : "post",
						data : {
							"currPage" : currPage,
							"pageSize" : pageSize
						},
						dataType : 'json',
						cache : true,
						beforeSend : function() {
							//open loading
						},
						complete : function() {
							//close loading
						},
						error : function() {
							alert("Ajax request error");
						},
						success : function(dd) {
							// alert(dd);
							$("#id_contacts_data").html("");
							var str = '';
							if (dd != null && dd.length > 0) {
								for ( var i in dd[0]) {
									str += '<tr>';
									str += "<td><input type='checkbox' value="+dd[0][i].bianHao +" name='checkone' class='checkone'></td>";
									str += "<td>" + dd[0][i].bianHao + "</td>";
									str += "<td>" + dd[0][i].xingMing + "</td>";
									str += "<td>" + dd[0][i].zhiWu + "</td>";
									str += "<td>" + dd[0][i].lianXiFangShi
											+ "</td>";
									str += "<td>" + dd[0][i].youXiang + "</td>";
									str += "<td>" + dd[0][i].gongZuoDanWei
											+ "</td>";
									str += "<td><span><a href='#'  onclick='modify(this)'> 编辑</a></span>"
											+ "<span><a href='#' onclick='show(this)' > 详情</a></span>"
											+ "<span><a  class='shanchuone' href='javascript:void(0)' style='cursor:point;'> 删除</a></span>"
											+ '</td >' + '</tr>';
								}
							}
							$("#id_contacts_data").append(str);
							$("#page").whjPaging("setPage", currPage, dd[1]);

							$("#biaogeneirong tbody tr").mouseover(function() {
								$(this).addClass("success");
							}).mouseout(function() {
								$(this).removeClass("success");
							});

							$("#checks").click(function() {
								var value = $(this).prop("checked");
								$(".checkone").prop("checked", value);
							});

							$(".shanchuone")
									.click(
											function() {
												var id = $(this).parents("td")
														.parents("tr")
														.children()[1].innerHTML;

												Ewin.confirm(
																{
																	message : "确认要删除选择的数据吗？"
																})
														.on(
																function(e) {
																	if (!e) {
																		return;
																	}
																	$
																			.ajax({
																				url : "ShanChu",
																				type : "post",
																				data : {
																					id : id,
																					action : "deletes"
																				},
																				async : false,
																				dataType : 'json',
																				success : function(
																						data) {
																					if (data[0] === "ok") {
																						if (top.topManager)
																							top.topManager
																									.reloadPage();
																						//alert("删除成功!");
																					}
																				},
																				error : function() {
																					alert("Ajax request error");
																				}
																			});

																});
											});
						}
					});
		}
		getContactsList(1, 10);

		function SouSuo() {
			var txt = $("#sou").val();
			window.location.href = "MoHuSouSuo?txt=" + txt;
		}
	</script>
</body>
</html>