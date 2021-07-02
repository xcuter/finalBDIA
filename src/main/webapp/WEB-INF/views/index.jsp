<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>SimpleBank</h1>
<h2>U nas nie zyskasz</h2>
<h3>Zaloguj się aby zacząć</h3>
<a href="${pageContext.request.contextPath}/login">Przejdź do logowania</a>
<h3>lub Zarejestruj się</h3>
<a href=${pageContext.request.contextPath}/signup>Zarejestruj</a>
</body>
</html>