<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StudentDB</title>
    <!-- Додайте ваші стилі тут -->

    <!-- Приклад стилів для хедера -->
    <style>
        body {
            background-color: navajowhite;
            margin: 0;
            font-family: Arial, sans-serif;
        }

        header {
            background-color: #333;
            padding: 10px;
            color: white;
            text-align: center;
        }

        #logo {
            width: 50px; /* Розмір логотипу */
            height: auto;
            vertical-align: middle;
        }

        h1 {
            display: inline-block;
            margin: 0;
            margin-left: 10px;
        }

        nav {
            display: flex;
            justify-content: space-around;
            margin-top: 10px;
        }

        nav a {
            color: white;
            text-decoration: none;
            padding: 5px 10px;
            border-radius: 5px;
        }

        nav a:hover {
            background-color: #555;
        }

        #search-input {
            padding: 5px;
            border-radius: 5px;
            border: none;
        }

        #search-button {
            background-color: #555;
            color: white;
            border: none;
            padding: 5px 10px;
            border-radius: 5px;
            cursor: pointer;
        }
        .list {
            font-family: Arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        .list th, .list td {
            background-color: #f2f2f2;
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }



        .list tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .list tr:hover {
            background-color: #ddd;
        }
        .button-link {
            display: block;
            margin: 0 auto;

            text-decoration: none;
            color: #0056b3;



            cursor: pointer;
            transition: background-color 0.3s ease;
        }
    </style>
</head>

<body>
<header>
    <#--    <img id="logo" src="your_logo_path.png" alt="StudDB Logo">-->
    <h1>StudentDB</h1>
    <nav>

        <input type="text" id="search-input" placeholder="Search">
        <button id="search-button">Filter</button>

        <a href="#">Login</a>
    </nav>
</header>
<h1>Student Form</h1>
<form method="post" action="/student/send">
    <table>
        <tbody>
        <tr>
            <td><label for="name">Name</label></td>
            <td><input id="name" type="text" name="name"></td>
        </tr>
        <tr>
            <td><label for="surname">Surname</label></td>
            <td><input id="surname" type="text" name="surname"></td>
        </tr>
        <tr>
            <td><label for="email">Email</label></td>
            <td><input id="email" type="email" name="email"></td>
        </tr>
        <tr>
            <td><label for="group">Group</label></td>
            <td><input id="group" type="text" name="group"></td>
        </tr>
        <tr>
            <td><label for="faculty">Faculty</label></td>
            <td><input id="faculty" type="text" name="faculty"></td>
        </tr>
        </tbody>
    </table>
    <input type="submit" name="send" value="Send">
</form>
<table class="list">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Group</th>
        <th>Faculty</th>
        <th>Grades</th>
        <th>Delete</th>
    </tr>
    <#list students as student>
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.surname}</td>
            <td>${student.email}</td>
            <td>${student.group}</td>
            <td>${student.faculty}</td>
            <td>
                <a href="${"/grades/${student.id}"}" class="button-link">View Grades</a>
            </td>
            <td>
                <form method="post" action="/student/delete/${student.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>

        </tr>
    </#list>
</table>
</body>

</html>
