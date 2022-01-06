<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/6/2022
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h1>
    <button>
        <a href="/home?action=create">Add New Product</a>
    </button>
</h1>
<form action="/home?action=search" method="post">
    <input type="text" name="find" value="Search">
    <input type="submit" value="search">
</form>
<table class="table table-bordered">
    <tr>
        <th>Product List</th>
    </tr>
    <tr>
        <th>#</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Category</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach items="${list}" var="p" varStatus="loop">
        <tr>
            <td><p>${p.id}</p></td>
            <td><p>${p.name_sp}</p></td>
            <td><p>${p.price}</p></td>
            <td><p>${p.quantity}</p></td>
            <td><p>${p.color}</p></td>
            <td><p>${p.name_category}</p></td>
            <td>
                <button>
                    <a href="/home?action=edit&id=${p.id}">
                        Edit
                    </a>
                </button>
            </td>
            <td>
                <button>
                    <a href="/home?action=delete&id=${p.id}">
                        Delete
                    </a>
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
