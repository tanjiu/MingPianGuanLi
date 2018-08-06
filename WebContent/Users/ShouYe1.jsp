<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<% 
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";	
%>

<head>
<title>名片管理</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath }/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div class="header">

		<div class="dl-title">
			<a href="#" target="_blank">
				<!-- 仅仅为了提供文档的快速入口，项目中请删除链接 --> <span class="lp-title-port">名片</span><span
				class="dl-title-text">管理</span>
				</a>			
		</div>

		<div class="dl-log">
			欢迎您，<span class="dl-log-user" id="yhm"><%=session.getAttribute("role") %></span><a
				href="../../test2/ZhuXiaoDengLu?action=2" title="退出系统" class="dl-log-quit">[退出]</a>
		</div>
	</div>
	<div class="content">
		<div class="dl-main-nav">			
			<ul id="J_Nav" class="nav-list ks-clear">
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-home">首页</div></li>

			</ul>
		</div>
		<ul id="J_NavContent" class="dl-tab-conten">

		</ul>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/bui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/config.js"></script>

	<script>
		BUI.use('common/main', function() {
			var config = [ {
				id : 'menu',
				homePage : 'code',
				menu : [ {
					text : '名片',
					items : [ {
						id : 'code',
						text : '名片列表',
						href : 'List1.jsp',
						closeable : false
					} ]
				}, {
					text : '回收站',
					items : [ {
						id : 'huishouzhan',
						text : '回收站',
						href : 'HuiShouList.jsp'
					} ]
				} ]
			} ];
			new PageUtil.MainPage({
				modulesConfig : config
			});
		});
		
		
		
	</script>
</body>
</html>
