<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1>
<hr>
<h4>Панель администратора</h4>
<table border="1">
    <tr>
        <th>Email</th>
        <th>Номер телефона</th>
        <th>Активність</th>
        <th>Ролі</th>
        <th>Бан</th>
        <th>Редагування</th>

    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th><#if user.phoneNumber??>${user.phoneNumber}</#if></th>
            <th><#if user.active>true<#else>false</#if></th>
            <th><#list user.roles as role>${role}</#list></th>
            <th>
                <form action="/admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Бан">
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.id}">Редагування</a></th>
        </tr>
    <#else>
        <h3>Користувачів нема</h3>
    </#list>
</table>
</body>
</html>
