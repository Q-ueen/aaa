<%--
  Created by IntelliJ IDEA.
  User: 16681
  Date: 2025/2/26
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inventory Form</title>
    <%--    <link rel="stylesheet" href="css/styles.css">--%>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #333;
            text-align: center;
            margin-top: 20px;
        }

        form {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"],
        button {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #428bca;
            text-decoration: none;
            padding: 10px;
            background-color: #f9f9f9;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        a:hover {
            background-color: #e9e9e9;
        }
    </style>
</head>
<body>
<h1>库存</h1>
<form action="inventory" method="post">
    <input type="hidden" name="id" value="${item.id}">
    <label for="name">名称:</label>
    <input type="text" id="name" name="name" value="${item.name}" required>
    <label for="quantity">数量:</label>
    <input type="number" id="quantity" name="quantity" value="${item.quantity}" required>
    <label for="price">价格:</label>
    <input type="number" id="price" name="price" step="0.01" value="${item.price}" required>
    <label for="category_id">类别:</label>
    <input type="number" id="category_id" name="category_id" value="${item.category_id}" required>
    <label for="supplier_id">供应商:</label>
    <input type="number" id="supplier_id" name="supplier_id" value="${item.supplier_id}" required>
    <button type="submit" name="action" value="insert">提交</button>
</form>
<a href="inventory-list.jsp" class="add-button">返回库存清单</a>
</body>
</html>