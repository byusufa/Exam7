<%@ page import="uz.pdp.exam7.repo.PostRepo" %>
<%@ page import="uz.pdp.exam7.entity.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.exam7.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: macbook_uz
  Date: 10/12/24
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Post</title>
</head>
<body>
<%
    PostRepo postRepo = new PostRepo();
    List<Post> posts = postRepo.findAllByLatest();
%>

<div class="container mt-5">
    <div class="d-flex justify-content-end gap-2 mb-4">
        <a href="/login.jsp" class="btn btn-danger">Back</a>
    </div>
    <div class="row justify-content-center">
        <% for (Post post : posts) { %>
        <div class="col-md-4 mb-4">
            <div class="card shadow-sm h-100">
                <img src="/file/get?id=<%=post.getImage().getId()%>"
                     class="card-img-top"
                     alt="Image not found"
                     style="width: 100%; height: 200px; object-fit: contain;">
                <div class="card-body">
                    <span><strong>Title:</strong> <%= post.getTitle()%></span>
                    <span><strong>Description:</strong> <%= post.getDescription() %></span>
                    <div class="text-center">
                        <a href="/comment.jsp?id=<%=post.getId()%>" class="btn btn-primary btn-sm">Comments</a>
                    </div>
                </div>
            </div>
        </div>
        <% } %>
    </div>
</div>
</body>
</html>
