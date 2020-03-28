<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User info form</title>
</head>
<body>

<form method="POST" action="uinform" enctype="multipart/form-data">
	Photo upload: <input type="file" name="file" accept=".png">
	<input type="submit" value="Upload">
</form>
<br><br>
${message }
<br><br>
<img src="data/user/${sessionScope.client.getUsername() }" />

</body>
</html>