<%@ page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<h3>管理员列表</h3><a href="admin/add.jsp" class="ajax-link">添加</a>
	<table  class="table table-striped table-bordered">
		<tr>
			<th>头像</th>
			<th>姓名</th>
			<th>电子邮件</th>
			<th>QQ</th>
			<th>电话号码</th>
			<th>类型</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${adminList }" var="m">
			<tr>
				<td><img alt="" src="down.do?file=${m.photo }" style="width:60px;height:60px"></td>
				<td>${m.realname }</td>
				<td>${m.email }</td>
				<td>${m.qq }</td>
				<td>${m.phone }</td>
				<td>${constantMap.admintype[m.type] }</td>
				<td>${constantMap.adminstatus[m.status] }</td>
				<td>
					<a href="admin/edit.do?id=${m.id }" class="ajax-link">编辑</a>/
					<a href="admin/delete.do?id=${m.id }" class="ajax-link-delete">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>