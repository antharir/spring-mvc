<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>App Login</title>
</head>
<body>

    <p><font color="red">${errorMessage}</font></p>

	<form action="/login.do" method="post">

		<input type="text" name="username"> <input type="password"
			name="password">
		<button type="submit">Submit</button>

	</form>

</body>
</html>