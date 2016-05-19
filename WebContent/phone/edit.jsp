<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="phone/edit.do" method="post"  class="form-horizontal ajax-form" okUrl="phone/list.do">
<h3>修改商品</h3>
<input type="hidden" name="id" value="${p.id }">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">型号：</label>
		<div  class="col-sm-10">
			<input type="text" id="name" name="name" class="form-control" placeholder="型号" value="${p.name }">
		</div>
	</div>
	<div class="form-group">
		<label for="facId" class="col-sm-2 control-label">产地：</label>
		<div  class="col-sm-10">
			<select  class="form-control" id="facId"	name="facId" >
				<c:forEach items="${factoryList }" var="fac">
					<option value="${fac.id }" ${fac.id eq p.id ? "selected" : ""}>${fac.name }</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="price" class="col-sm-2 control-label">价格：</label>
		<div  class="col-sm-10">
			<input type="text" id="price" name="price" class="form-control" placeholder="价格" value="${p.price }">
		</div>
	</div>
	<div class="form-group">
		<label for="phoneCount" class="col-sm-2 control-label">数量：</label>
		<div  class="col-sm-10">
			<input type="text" id="phoneCount" name="phoneCount" class="form-control" placeholder="数量" value="${p.phoneCount }">
		</div>
	</div>
	<div class="form-group">
		<label for="description" class="col-sm-2 control-label">描述：</label>
		<div  class="col-sm-10">
			<input type="text" id="description" name="description" class="form-control" placeholder="描述" value="${p.description }">
		</div>
	</div>
	
	<div class="form-group">
	
		<div  class="col-sm-2 col-sm-offset-2">
			<button type="submit" class="btn btn-info">提交</button>
			
		</div>
	</div>
</form>