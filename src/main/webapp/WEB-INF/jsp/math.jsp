<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Preisler Math</title>
    <mvc:resources mapping="/resources/**" location="/resources/static/" />
    <link href="/style/style.css" rel="stylesheet"/>
</head>
<body>
    <h1>Math</h1>
    <form action="/math" method="POST">
        <label for="num1"></label>
        <input id="num1" name="num1" type="text">

        <label for="num2"></label>
        <input id="num2" name="num2" type="text">

        <label for="op"></label>
        <select name="op" id="op">
            <option value="add">+</option>
            <option value="sub">-</option>
            <option value="mul">*</option>
            <option value="div">÷</option>
        </select>

        <input type="submit" value="save">
    </form>

    <h2>Results</h2>
    <h1>Result</h1>
    <h1>${text}</h1>
</body>
</html>