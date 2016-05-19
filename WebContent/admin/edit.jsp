<%@ page pageEncoding="UTF-8"%>
<form action="admin/edit.do" method="post"  class="form-horizontal ajax-form" okUrl="admin/list.do">
<h3>修改管理员</h3>
<input type="hidden" id="id" name="id" class="form-control" value="${m.id }">
<input type="hidden" id="passwd" name="passwd" class="form-control" value="${m.passwd }">
	<div class="form-group">
		<label for="photo" class="col-sm-2 control-label">头像：</label>
		<div  class="col-sm-10">
			<input type="text" id="photo" name="photo" class="form-control" placeholder="头像" value="${m.photo }">
		</div>
	</div>
	<div class="form-group">
		<label for="realname" class="col-sm-2 control-label">姓名：</label>
		<div  class="col-sm-10">
			<input type="text" id="realname" name="realname" value="${m.realname }" class="form-control" placeholder="姓名">
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">电子邮件：</label>
		<div  class="col-sm-10">
			<input type="text" id="email" name="email" class="form-control" placeholder="电子邮件" value="${m.email }">
		</div>
	</div>
	<div class="form-group">
		<label for="qq" class="col-sm-2 control-label">QQ：</label>
		<div  class="col-sm-10">
			<input type="text" id="qq" name="qq" class="form-control" placeholder="QQ" value="${m.qq }">
		</div>
	</div>
	<div class="form-group">
		<label for="phone" class="col-sm-2 control-label">电话号码：</label>
		<div  class="col-sm-10">
			<input type="text" id="phone" name="phone" class="form-control" placeholder="电话号码" value="${m.phone }">
		</div>
	</div>
	<div class="form-group">
		<label for="type" class="col-sm-2 control-label">类型：</label>
		<div  class="col-sm-10">
			<label class="radio-inline">
				<input type="radio" name="type" value="1" checked>用户
			</label>
			<label class="radio-inline">
				<input type="radio" name="type" value="2" ${m.type eq '2' ? "checked" : "" }>商品
			</label>
			<label class="radio-inline">
				<input type="radio" name="type" value="3" ${m.type eq '3' ? "checked" : ""}>订单
			</label>
			<label class="radio-inline">
				<input type="radio" name="type" value="4" ${m.type eq '4' ? "checked" : ""}>物流
			</label>
		</div>
	</div>
	<div class="form-group">
		<label for="status" class="col-sm-2 control-label">状态：</label>
		<div  class="col-sm-10">
			<label class="radio-inline">
				<input type="radio" name="status" value="1" checked>正常
			</label>
			<label class="radio-inline">
				<input type="radio" name="status" value="2" ${m.type eq '2' ? "checked" : "" }>禁用
			</label>
			<label class="radio-inline">
				<input type="radio" name="status" value="3" ${m.type eq '3' ? "checked" : "" }>删除
			</label>
		</div>
	</div>
	<div class="form-group">
	
		<div  class="col-sm-2 col-sm-offset-2">
			<button type="submit" class="btn btn-info">提交</button>
			
		</div>
	</div>
</form>