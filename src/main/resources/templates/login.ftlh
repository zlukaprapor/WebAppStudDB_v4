<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1>
<hr>
<h4>Авторизація</h4>
<form action="/login" method="post">
    Эл. почта: <input type="email" name="username" id="email"><br><br>
    Пароль: <input type="password" name="password" id="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вхід"/>
</form>
<a href="/registration">Зареєструватись</a>
</body>
</html>