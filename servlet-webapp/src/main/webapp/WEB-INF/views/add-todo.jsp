
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<form:form method="post" commandName="todo">

		<form:hidden path="id" />
		<form:hidden path="user" />
		<form:hidden path="done" />

		<fieldset class="form-group">
			<form:label path="desc">Description</form:label>
			<form:input type="text" path="desc" class="form-control" />
			<form:errors path="desc" cssClass="text-danger" />
		</fieldset>


		<fieldset class="form-group">
			<form:label path="desc">Target Date</form:label>
			<form:input type="text" path="targetDate" class="form-control" />
			<form:errors path="targetDate" cssClass="text-danger" />
		</fieldset>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
</div>


<%@ include file="common/footer.jspf"%>
