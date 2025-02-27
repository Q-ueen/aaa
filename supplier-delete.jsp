<%--
  Created by IntelliJ IDEA.
  User: 16681
  Date: 2025/2/26
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>删除供应商</title>
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

        .message {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
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
<h1>删除供应商</h1>
<div class="message">
    <%
        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                // 数据库连接
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_system", "root", "password");

                // 删除供应商
                String sql = "DELETE FROM suppliers WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt(id));
                int rows = pstmt.executeUpdate();

                if (rows > 0) {
                    out.println("供应商删除成功！");
                } else {
                    out.println("未找到该供应商！");
                }
            } catch (Exception e) {
                e.printStackTrace();
                out.println("删除供应商时发生错误！");
            } finally {
                try {
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            out.println("无效的供应商ID！");
        }
    %>
    <a href="supplier-list.jsp">返回供应商列表</a>
</div>
</body>
</html>
