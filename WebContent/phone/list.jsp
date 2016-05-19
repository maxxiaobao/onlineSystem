<%@ page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<h3>管理员列表</h3><a href="phone/add.jsp" class="ajax-link">添加</a>
	<table  class="table table-striped table-bordered">
		<tr>
			<th>型号</th>
			<th>产地</th>
			<th>价格</th>
			<th>数量</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${phoneList }" var="p">
			<tr>
				<td>${p.name }</td>
				<td>${p.facName }</td>
				<td>${p.price }</td>
				<td>${p.phoneCount }</td>
				<td>${p.description }</td>
				<td>
					<a href="phone/edit.do?id=${p.id }" class="ajax-link">编辑</a>/
					<a href="phone/delete.do?id=${p.id }" class="ajax-link-delete">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>