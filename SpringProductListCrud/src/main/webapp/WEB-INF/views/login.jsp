<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center" border="2" style="border-style:groove;padding:10px;background-color:powderblue;margin:auto;width:fit-content;font:bold">
<h1>Login Page</h1><br>
<form action="validate" method="post">
Enter Username:<input type="text" name="uname" id="uname"><br><br>
Enter password:<input type="password" name="pass" id="pass"><br><br>
<button type="submit" name="btn">Login</button><br>
${msg}
</form>
</div>
</body>
</html>