<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/6/2022
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
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
<h1>Edit product</h1>
<h2>
    <button>
        <a href="/home">Back</a>
    </button>
</h2>
<form method="post" class="form-check-label">
    <h3>Product name</h3>
    <input type="text" name="name" value="${requestScope["sp"].name_sp}">
    <h3>Product price</h3>
    <input type="text" name="price" value="${requestScope["sp"].price}">
    <h3>Product quantity</h3>
    <input type="text" name="quantity" value="${requestScope["sp"].quantity}">
    <h3>Product color</h3>
    <input type="text" name="color value="${requestScope["sp"].color}"">
    <h3>Product description</h3>
    <input type="text" name="description" value="${requestScope["sp"].mota_sp}">
    <h3>Category</h3>
    <select name="category">
        <option value="1">Phone</option>
        <option value="2">Telephone</option>
    </select>
    <input type="submit" value="Add">
</form>
</body>
</html>
