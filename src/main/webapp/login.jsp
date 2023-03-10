<%--
  Created by IntelliJ IDEA.
  User: gijoe250
  Date: 3/9/23
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        request.setAttribute("userName", userName);
        request.setAttribute("password", password);

        if (userName != null && password != null && userName.equals("admin") && password.equals("password")){
            response.sendRedirect("/profile.jsp");
        }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="navbar.jsp" %>
<form>
    <label for="userName"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="userName" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <button type="submit">Login</button>
</form>

</body>
</html>
