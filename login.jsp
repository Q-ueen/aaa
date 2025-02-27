<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
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
            max-width: 400px;
            margin: 50px auto;
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
        input[type="password"],
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

        .error {
            color: red;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<h1>用户登录</h1>
<form action="login" method="post">
    <label for="username">用户名:</label>
    <input type="text" id="username" name="username" required>
    <label for="password">密码:</label>
    <input type="password" id="password" name="password" required>
    <button type="submit">登录</button>
</form>
<c:if test="${not empty error}">
    <div class="error">${error}</div>
</c:if>
</body>
</html>