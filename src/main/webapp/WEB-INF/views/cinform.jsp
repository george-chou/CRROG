<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company info form</title>
</head>
<body>

<form method="POST" action="cinform" enctype="multipart/form-data">
	License upload: <input type="file" name="file" accept=".png">
	<input type="submit" value="Upload">
</form>
<br><br>
${message }
<br><br>
<img src="data/enterprise/${sessionScope.client.getEmail() }" />

</body>
</html>