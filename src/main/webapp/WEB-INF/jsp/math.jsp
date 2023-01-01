<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Preisler Math</title>
    <mvc:resources mapping="/resources/**" location="/resources/static/" />
    <link href="/style/style.css" rel="stylesheet"/>
</head>
<body>
    <div id="math_s">
        <h1>Math</h1>
    <div class="cont" id="calculator_cont">
        <div id="calculator">
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
    </div>
    </div>
    <div class="cont" id="history_cont">
        <h1>History</h1>
        <div id="history">${text}</div>
    </div>
</div>
</body>
</html>