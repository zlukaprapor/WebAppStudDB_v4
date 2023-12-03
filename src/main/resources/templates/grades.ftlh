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
<h2>Grades for Student</h2>

<#list disciplines as discipline>
    <h3>${discipline.discipline}</h3>

    <table class="list">
        <tr>
            <th>Subject</th>
            <th>Grade</th>
            <th>ECTS</th>
        </tr>
        <#list grades as grade>
            <#if grade.disciplineId == discipline.id>
                <tr>
                    <td>${grade.subject}</td>
                    <td>${grade.grade}</td>
                    <td>${grade.ects}</td>
                </tr>
            </#if>
        </#list>
    </table>
</#list>
</body>

</html>
