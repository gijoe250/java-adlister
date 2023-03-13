<%--
  Created by IntelliJ IDEA.
  User: gijoe250
  Date: 3/13/23
  Time: 9:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pizza Menu</title>
</head>
<body>
<form method="POST" action="./pizza-order">
    <label for="crust">Choose a crust:</label>
    <select name="crust" id="crust">
        <option value="thinCrust">Thin Crust</option>
        <option value="stuffedCrust">Stuffed Crust</option>
    </select>
    <br><br>

    <input type="checkbox" id="topping1" name="topping1" value="chicken">
    <label for="topping1"> Chicken </label><br>
    <input type="checkbox" id="topping2" name="topping2" value="blackOlives">
    <label for="topping2"> Black Olives</label><br>
    <input type="checkbox" id="topping3" name="topping3" value="mushroom">
    <label for="topping3"> Mushroom</label><br><br>

    <label for="address">Delivery Address:</label>
    <input type="text" id="address" name="address"><br><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>
