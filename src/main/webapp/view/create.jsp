<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/6/2022
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new product</title>
</head>
<body>
<h1>Add new product</h1>
<h2>
    <button>
        <a href="/home">Back</a>
    </button>
</h2>
<form method="post">
    <h3>Product name</h3>
    <input type="text" name="name">
    <h3>Product price</h3>
    <input type="text" name="price">
    <h3>Product quantity</h3>
    <input type="text" name="quantity">
    <h3>Product color</h3>
    <input type="text" name="color">
    <h3>Product description</h3>
    <input type="text" name="description">
    <h3>Category</h3>
    <select name="category">
        <option value="1">Phone</option>
        <option value="2">Telephone</option>
    </select>
    <input type="submit" value="Add">
</form>
</body>
</html>
