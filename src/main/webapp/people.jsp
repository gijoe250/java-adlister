<%@ page import="model.Person"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: gijoe250
  Date: 3/10/23
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
  Person p1 = new Person("Fred Smith", 10);
  Person p2 = new Person("Joe Garcia", 20);
  List<Person> people = new ArrayList<>(Arrays.asList(
          p1,
          p2
  ));

  request.setAttribute("people", people);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
  People
</h1>
<c:forEach var="person" items="${people}">
  <h3>
      ${person.name} ${person.age}
    <c:if test="${person.age < 18}">
      Its a child!
    </c:if>
  </h3>
</c:forEach>

</body>
</html>
