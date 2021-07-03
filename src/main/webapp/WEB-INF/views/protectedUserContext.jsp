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
    <title> Hello ${FullName}</title>
</head>
<body>
        <div>
            <h1>hello ${FullName}</h1>
            <h2>Twój stan konta : ${ammount}</h2>
            <form action="${pageContext.request.contextPath}/addAmmount">
                <input name="ammount" type="text" placeholder="Kwota" required autofocus>
                <button type="submit">Wpłać</button>
            </form>
            <h1>Przelew standardowy</h1>
            <form action="${pageContext.request.contextPath}/transferAmmount">
                <input name="toAccount" type="text" placeholder="numer Konta do przelewu">
                <input name="ammount" type="text" placeholder="Kwota którą chcesz przelać">
                <button type="submit">Przelej</button>
            </form>
            <h1>Wypłata</h1>
            <form action="${pageContext.request.contextPath}/substractAmmount">
                <input name="ammount" type="text">
            </form>


        </div>
</body>
</html>
