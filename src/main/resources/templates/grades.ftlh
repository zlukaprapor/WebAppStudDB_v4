<!DOCTYPE html>
<html lang="en">

<head>
    <!-- meta та інші теги залишаються незмінними -->
</head>

<body>
<h2>Grades for Student</h2>
<hr>
<table class="list">
    <tr>
        <th>Subject</th>
        <th>Grade</th>
        <th>ECTS</th>
    </tr>
    <#list grades as grade>
        <tr>
            <td>${grade.subject}</td>
            <td>${grade.grade}</td>
            <td>${grade.ects}</td>
            <td>
                <form action="/grades/delete" method="post">
                    <input type="hidden" name="gradeId" value="${grade.id}">
                    <input type="hidden" name="studentId" value="${studentId}">
                    <input type="submit" value="Видалити оцінку">
                </form>
            </td>
        </tr>
    </#list>
    <#list disciplines as discipline>
        <tr>
            <td>${discipline.discipline}</td>
            <td>N/A</td> <!-- Since disciplines may not have grades -->
            <td>N/A</td> <!-- You can adjust this based on your requirements -->
            <td>
                <form action="/disciplines/delete" method="post">
                    <input type="hidden" name="disciplineId" value="${discipline.id}">
                    <input type="hidden" name="studentId" value="${studentId}">
                    <input type="submit" value="Видалити дисципліну">
                </form>
            </td>
        </tr>
    </#list>
</table>
<hr>
<form action="/grades/add" method="post">
    <input type="hidden" name="studentId" value="${studentId}">
    Subject: <input type="text" name="subject" required><br>
    Grade: <input type="number" name="grade" min="10" max="100" required><br>
    ECTS: <input type="text" name="ects"  min="A" max="F" required><br>
    <input type="submit" value="Додати оцінку">
</form>
<hr>
<form action="/disciplines/add" method="post">
    <input type="hidden" name="studentId" value="${studentId}">
    <label for="disciplineName">Discipline:</label>
    <input type="text" id="disciplineName" name="disciplineName" required />
    <button type="submit">Додати дисципліну</button>
</form>
<hr>
</body>

</html>
