<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StudentDB</title>

</head>
<body>
<header>
    <#--    <img id="logo" src="your_logo_path.png" alt="StudDB Logo">-->
    <h1>StudentDB</h1>
    <nav>
        <form action="/" method="get">
            <input type="text" name="name">
            <input type="submit" value="Пошук">
        </form>
    </nav>
</header>
<hr>
<h2>Student Form</h2>
<#list students as student>
    <div>
        <p>
            <b>
                ${student.name} ${student.surname}
            </b>
            ${student.student_group} ${student.faculty} | <a href="/grades/${student.id}">Оцінки....</a>

        </p>
        <form action="/student/delete/${student.id}" method="post">
            <input type="hidden" name="id" value="${student.id}">
            <input type="submit" value="Видалити">
        </form>
    </div>
<#else>
    <h3>Студенти в базі відсутні</h3>
</#list>
<hr>
<h3>Створити запис</h3>
<form action="/student/create" method="post">
    Name:<input type="text" name="name"/><br><br>
    Surname:<input type="text" name="surname"/><br><br>
    Email:<input type="text" name="email"/><br><br>
    Group:<input type="text" name="student_group"/><br><br>
    Faculty:<input type="text" name="faculty"/><br><br>
    <input type="submit" value="Створити">
</form>
<hr>

</body>
</html>
