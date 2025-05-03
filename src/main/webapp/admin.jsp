<%@ page import="uz.pdp.exam7.repo.PostRepo" %>
<%@ page import="uz.pdp.exam7.entity.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: macbook_uz
  Date: 10/12/24
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <title>Admin</title>
</head>
<body>
<%
    PostRepo postRepo = new PostRepo();
    List<Post> posts = postRepo.findAllByLatest();
%>
<div class="container mt-5">
    <div class="d-flex justify-content-end gap-2 mb-4">
        <a href="/addPost.jsp" class="btn btn-danger">Add Posts</a>
        <a href="/login.jsp" class="btn btn-danger">Back</a>
    </div>
    <div class="row">
        <% for (Post post : posts) { %>
        <div class="col-md-4 mb-4">
            <div class="card shadow-sm h-100">
                <img src="/file/get?id=<%=post.getImage().getId()%>"
                     class="card-img-top"
                     alt="Image not found"
                     style="width: 100%; height: 200px; object-fit: contain;">
                <div class="card-body">
                    <p class="card-text d-flex justify-content-between flex-wrap">
                        <span><strong>Title:</strong> <%= post.getTitle() %></span>
                        <span><strong>Description:</strong> <%= post.getDescription() %></span>
                        <span><strong>Created Date:</strong> <%= post.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) %></span>
                    </p>
                </div>
            </div>
        </div>
        <% } %>
    </div>
</div>

</body>
</html>
