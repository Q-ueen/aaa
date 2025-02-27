<%--
  Created by IntelliJ IDEA.
  User: 16681
  Date: 2025/2/26
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>供应商列表</title>
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

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px;
            text-align: center;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        a {
            color: #428bca;
            text-decoration: none;
            padding: 6px 12px;
            border: 1px solid #ddd;
            border-radius: 4px;
            background-color: #f9f9f9;
        }

        a:hover {
            background-color: #e9e9e9;
        }

        .add-button {
            display: block;
            width: 200px;
            margin: 20px auto;
            text-align: center;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }

        .add-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>供应商列表</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>名字</th>
        <th>联系信息</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSuppliers}" var="supplier">
        <tr>
            <td>${supplier.id}</td>
            <td>${supplier.name}</td>
            <td>${supplier.contact_info}</td>
            <td>
                <a href="supplier-form.jsp?id=${supplier.id}">编辑</a>
                <a href="supplier-delete.jsp?id=${supplier.id}" onclick="return confirm('是否确定删除此供应商?');">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="supplier-form.jsp" class="add-button">添加新的供应商</a>
</body>
</html>
