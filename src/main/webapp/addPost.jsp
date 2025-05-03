<%--
  Created by IntelliJ IDEA.
  User: macbook_uz
  Date: 10/12/24
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Add post</title>
</head>
<body>
<div class="d-flex justify-content-center align-items-center vh-100">
    <form action="/post/add" method="post" enctype="multipart/form-data"
          class="p-4 shadow-sm bg-light rounded"
          style="max-width: 600px; width: 100%;">
        <h3 class="mb-4 text-center">Add New Post</h3>
        <div class="mb-3">
            <label for="image" class="form-label">Upload Image</label>
            <input type="file" name="image" id="image" class="form-control">
        </div>

        <div class="mb-3">
            <label for="title" class="form-label">Title</label>
            <input type="text" name="title" id="title" placeholder="Enter title" class="form-control">
        </div>

        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <textarea name="description" id="description" placeholder="Enter description" class="form-control" rows="3"></textarea>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-danger">Save</button>
            <a href="/admin.jsp" class="btn btn-danger">Back</a>
        </div>
    </form>
</div>
</body>
</html>
