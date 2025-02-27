<%--
  Created by IntelliJ IDEA.
  User: 16681
  Date: 2025/2/25
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>主页</title>
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

    .container {
      max-width: 800px;
      margin: 50px auto;
      padding: 20px;
      background-color: #fff;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      border-radius: 8px;
      text-align: center;
    }

    a {
      display: block;
      margin: 20px 0;
      padding: 10px;
      background-color: #428bca;
      color: white;
      text-decoration: none;
      border-radius: 4px;
    }

    a:hover {
      background-color: #3071a9;
    }
  </style>
</head>
<body>
<h1>主页</h1>
<div class="container">
  <h2>欢迎, ${user.username}!</h2>
  <a href="category?action=list">类别管理</a>
  <a href="supplier?action=list">供应商管理</a>
  <a href="inventory?action=list">库存管理</a>
</div>
</body>
</html>