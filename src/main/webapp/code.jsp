<%--
  Created by IntelliJ IDEA.
  User: macbook_uz
  Date: 11/12/24
  Time: 00:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Code</title>
</head>
<body>


<div class="d-flex vh-100">
    <div class="m-auto text-center">
        <h3 class="mb-4">Verification Code</h3>
        <form action="/check/code" method="post">
            <input type="number" name="userCode" class="form-control mb-3 w-75 mx-auto" placeholder="Enter code"
                   required>
            <button type="submit" class="btn btn-primary w-75">Submit</button>
        </form>
    </div>
</div>


</body>
</html>
