

<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>


	Hi ${name }
	<a href="/add-todo" class="btn btn-primary">Add</a>
	<table class="table table-striped">
		<caption>Todo List</caption>
		<thead>
			<tr>
				<th>Desc</th>
				<th>Date</th>
				<th>Completed</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="todo" items="${todoList }">
				<tr>
					<td>${todo.desc }</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}" /></td>
					<td>${todo.done }</td>
					<td><a class="btn btn-primary"
						href="/update-todo?id=${todo.id }">Update</a></td>
					<td><a class="btn btn-danger"
						href="/delete-todo?id=${todo.id }">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

<%@ include file="common/footer.jspf" %> 