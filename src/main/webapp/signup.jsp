<%--
  Created by IntelliJ IDEA.
  User: Xecuter
  Date: 01.07.2021
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <div class="col-sm-6 col-md-4 col-md-offset-4">
        <form class="form-signin" method="post" action="#">
            <h2 class="form-signin-heading">Zarejestruj się</h2>
            <input name="email" type="email" class="form-control" placeholder="Email" required autofocus/>
            <input name="firstName" type="text"  class="form-control" placeholder="Imię" required autofocus/>
            <input name="lastName" type="text"  class="form-control" placeholder="Nazwisko" required autofocus/>
            <input name="password" type="password" class="form-control" placeholder="Hasło" required/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Zarejestruj</button>
        </form>
    </div>
</div>
</body>
</html>
