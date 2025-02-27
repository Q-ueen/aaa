<%--
  Created by IntelliJ IDEA.
  User: 16681
  Date: 2025/2/26
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Supplier Form</title>
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
<h1>供应商</h1>
<form action="supplier" method="post">
    <input type="hidden" name="id" value="${supplier.id}">
    <label for="name">姓名:</label>
    <input type="text" id="name" name="name" value="${supplier.name}" required>
    <label for="contact_info">联系方式:</label>
    <input type="text" id="contact_info" name="contact_info" value="${supplier.contact_info}" required>
    <button type="submit" name="action" value="insert">提交</button>
</form>
<a href="supplier-list.jsp" class="add-button">返回供应商列表</a>
</body>
</html>
