<%@ page pageEncoding="UTF-8"%>

<form action="admin/add.do" method="post"  class="form-horizontal ajax-form" id="file-input" okUrl="admin/list.do">
<h3>添加管理员</h3>
	<div class="form-group">
		<label for="realname" class="col-sm-2 control-label">姓名：</label>
		<div  class="col-sm-10">
			<input type="text" id="realname" name="realname" class="form-control" placeholder="姓名">
		</div>
	</div>
	<div class="form-group">
		<label for="photo" class="col-sm-2 control-label">头像：</label>
		<div  class="col-sm-10">
			<!-- <input type="text" id="photo" name="photo" class="form-control" placeholder="头像"> -->
			<img alt="" src="" id="img-photo">
			<input type="text" id="photo" name="photo" value="" />
			<button id="choose">选择头像</button>
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">电子邮件：</label>
		<div  class="col-sm-10">
			<input type="text" id="email" name="email" class="form-control" placeholder="电子邮件">
		</div>
	</div>
	<div class="form-group">
		<label for="qq" class="col-sm-2 control-label">QQ：</label>
		<div  class="col-sm-10">
			<input type="text" id="qq" name="qq" class="form-control" placeholder="QQ">
		</div>
	</div>
	<div class="form-group">
		<label for="phone" class="col-sm-2 control-label">电话号码：</label>
		<div  class="col-sm-10">
			<input type="text" id="phone" name="phone" class="form-control" placeholder="电话号码">
		</div>
	</div>
	<div class="form-group">
		<label for="type" class="col-sm-2 control-label">类型：</label>
		<div  class="col-sm-10">
			<label class="radio-inline">
				<input type="radio" name="type" value="1" checked>用户
			</label>
			<label class="radio-inline">
				<input type="radio" name="type" value="2">商品
			</label>
			<label class="radio-inline">
				<input type="radio" name="type" value="3">订单
			</label>
			<label class="radio-inline">
				<input type="radio" name="type" value="4">物流
			</label>
		</div>
	</div>
	<div class="form-group">
	
		<div  class="col-sm-2 col-sm-offset-2">
			<button type="submit" class="btn btn-info">提交</button>	
		</div>
	</div>
</form>
<form id="img-form" enctype="multipart/form-data">
	<input type="file" id="input-file" name="input-file">
</form>

<script type="text/javascript">
(function(){
	var inputfile = document.getElementById("input-file");
	var chooseimg = document.getElementById("choose");
	chooseimg.onclick = function(){
		inputfile.click();
	}
	inputfile.onchange = function(){
		var xhr = new XMLHttpRequest();
		var formdata = new FormData(document.getElementById("img-form"));
		xhr.open('post','up.do',true);
		xhr.send(formdata);
		xhr.onload = function(){
			alert(xhr.responseText);
			document.getElementById("photo").value = xhr.responseText;
			 document.getElementById("img-photo").src = "down.do?file="+xhr.responseText; 
		}
	}
})();

</script>



	








