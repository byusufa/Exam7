<%--
  Created by IntelliJ IDEA.
  User: macbook_uz
  Date: 10/12/24
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Login</title>
</head>
<body>
<div class="d-flex justify-content-center align-items-center vh-100">
    <div class="card p-4 shadow-sm" style="width: 300px;">
        <h3 class="text-center mb-4">Login</h3>
        <form action="/login" method="post">
            <div class="mb-3">
                <input type="text" placeholder="Email" name="email" class="form-control" >
            </div>
            <div class="mb-3">
                <input type="password" placeholder="Password" name="password" class="form-control" >
            </div>
            <button class="btn btn-danger w-100 mb-3">Enter</button>
            <div class="text-center">
                <a href="/register.jsp" class="text-info">Register</a>
            </div>
        </form>
    </div>
</div>


</body>
</html>
