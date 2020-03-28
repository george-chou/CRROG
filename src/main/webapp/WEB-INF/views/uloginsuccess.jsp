<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User data</title>
</head>
<body>

Hello user
<br><br>
${sessionScope.client}
<br><br>
<a href="uedit">Edit info</a>
<br><br>
<a href="logout">Log out</a>
<br><br>
</body>
</html>