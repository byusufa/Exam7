<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Objects" %>
<%@ page import="uz.pdp.exam7.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: macbook_uz
  Date: 10/12/24
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Register</title>
</head>
<body>

<%
    Object object = request.getAttribute("errors");
    Map<String, String> map = new HashMap<>();
    if (object != null) {
        map = (Map<String, String>) object;
    }

%>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-4">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h4 class="card-title text-center mb-4">Register</h4>
                    <form action="/register" method="post">
                        <div class="mb-3">
                            <input type="text"
                                   class="form-control" name="firstName"
                                   placeholder="Enter firstName">
                            <span><%=Objects.requireNonNullElse(map.get("firstName"), "")%></span>
                        </div>

                        <div class="mb-3">
                            <input type="text" class="form-control" name="lastName" placeholder="Enter lastName">
                            <span><%=Objects.requireNonNullElse(map.get("lastName"), "")%></span>
                        </div>

                        <div class="mb-3">
                            <input type="text" class="form-control" id="email" name="email" placeholder="Enter email">
                            <span><%=Objects.requireNonNullElse(map.get("email"), "")%></span>
                        </div>

                        <div class="mb-3">
                            <input type="password" class="form-control" name="password"
                                   placeholder="Enter password">
                            <span><%=Objects.requireNonNullElse(map.get("password"), "")%></span>
                        </div>

                        <div class="mb-3">
                            <input type="password" class="form-control" name="passwordRepeat"
                                   placeholder="Re-enter password">
                            <span><%=Objects.requireNonNullElse(map.get("passwordRepeat"), "")%></span>
                        </div>

                        <div class="d-grid">

                            <button type="submit" class="btn btn-danger">Sign Up</button>

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
