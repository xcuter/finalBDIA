<%--
  Created by IntelliJ IDEA.
  User: Xecuter
  Date: 02.07.2021
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title> Hello ${user}</title>
</head>
<body>
        <div>
            <h1>hellow ${user}</h1>
            <form action="${pageContext.request.contextPath}/test" action="#">
                <input name="ammount" type="text" placeholder="Kwota" required autofocus>
                <button type="submit">Przelej</button>
            </form>


        </div>
</body>
</html>
