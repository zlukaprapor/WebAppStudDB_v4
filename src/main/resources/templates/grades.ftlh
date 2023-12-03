<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StudentDB</title>
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
