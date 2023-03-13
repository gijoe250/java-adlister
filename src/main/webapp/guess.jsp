<%--
  Created by IntelliJ IDEA.
  User: gijoe250
  Date: 3/13/23
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guessing Game</title>
</head>
<body>
<form method="POST" action="./guess">
    <label for="guess">Guess a number between 1 and 3:</label>
    <input type="text" id="guess" name="guess"><br><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>
