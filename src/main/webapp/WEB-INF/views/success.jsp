<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My data</title>
</head>
<body>

Hello, here is your completed information:
<br><br>
${sessionScope.user}
<br><br>
<a href="logout">Log out</a>
<br><br>
</body>
</html>