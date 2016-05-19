<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="res/css/bootstrap.css" rel="stylesheet">
<link href="res/css/dashboard.css" rel="stylesheet">
<title>信息管理系统</title>
</head>
<body>

		<nav class="navbar navbar-inverse navbar-fixed-top">
	      <div class="container-fluid">
	        <div class="navbar-header">
	          <a class="navbar-brand" href="#">手机商城管理系统</a>
	        </div>
	        <div id="navbar" class="navbar-collapse collapse">
	          <ul class="nav navbar-nav navbar-right">
	            <li><a href="#">退出系统</a></li>
	          </ul>
	        </div>
	      </div>
	    </nav>
	    
	    <div class="container-fluid">
	      	<div class="row">
		        <div class="col-sm-3 col-md-2 sidebar">
		          <ul class="nav nav-sidebar">
		            <li><a  href="admin/list.do" class="ajax-link">用户管理</a></li>
		            <li><a  href="phone/list.do" class="ajax-link">商品管理</a></li>
		            <li><a href="#">物流管理</a></li>
		          </ul>
		        </div>
	        </div>
        </div>
          
	<div id="main" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	</div>

</body>
<script type="text/javascript" src="res/js/jquery-1.11.1.js"></script>
<script src="res/js/bootstrap.js"></script>
<script type="text/javascript" src="res/js/index.js"></script>
</html>