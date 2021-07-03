<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Bank - login</title>
</head>
<body>
<div class="container">
    <div class="col-sm-6 col-md-4 col-md-offset-4">
        <form class="form-signin" action="j_security_check" accept-charset="UTF-8" method="post">
            <h2 class="form-signin-heading">Zaloguj się</h2>
            <input name="j_username" type="text" class="form-control" placeholder="Nazwa uzytkownika" required autofocus>
            <input name="j_password" type="password" class="form-control" placeholder="Hasło" required>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>
            <p>Nie masz konta? <a href="${pageContext.request.contextPath}/signup">Zarejestruj się</a></p>
        </form>
    </div>
</div>
</body>
</html>
