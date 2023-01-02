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
    <div id="math_cont">
    <div class="cont" id="calculator_cont">
        <div id="calculator">
        <h1>Calculator</h1>
        <form action="/math" method="POST">
            <label for="num1">Number1</label>
            <input id="num1" name="num1" placeholder="XXXXX" type="text">
    
            <label for="num2">Number2</label>
            <input id="num2" name="num2" placeholder="XXXXX" type="text">
    
            <label for="op">Operator</label>
            <select name="op" id="op">
                <option value="add">+</option>
                <option value="sub">-</option>
                <option value="mul">*</option>
                <option value="div">÷</option>
            </select>
    
            <input id="sbutt" type="submit" value="Calculate">
        </form>
    </div>
    </div>
    <div class="cont" id="history_cont">
        <h1>History</h1>
        <div id="history">${text}</div>
    </div>
</div>
</div>
</body>
</html>