<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: gijoe250
  Date: 3/10/23
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  Product p1 = new Product("food", 50);
  Product p2 = new Product("clothes", 90);

  List<Product> products = new ArrayList<>(Arrays.asList(
          p1,
          p2
  ));

  request.setAttribute("products", products);

%>
<html>
<head>
    <title>Products</title>
</head>
<body>
<div>
  <c:forEach var="product" items="${products}">
    <h3>${product.getName()} ${product.costInCents}</h3>
  </c:forEach>

</div>

</body>
</html>
