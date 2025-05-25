<%@ page import="uz.pdp.exam7.repo.PostRepo" %>
<%@ page import="uz.pdp.exam7.entity.Post" %>
<%@ page import="uz.pdp.exam7.entity.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="lombok.Data" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%@ page import="uz.pdp.exam7.repo.PostRepo" %><%--
  Created by IntelliJ IDEA.
  User: macbook_uz
  Date: 10/12/24
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Comment</title>
</head>
<body>

<%
    Integer id = Integer.parseInt(request.getParameter("id"));
    PostRepo postRepo = new PostRepo();
    Post post = postRepo.findById(id);
    session.setAttribute("post", post);
%>

<div class="container mt-5">

    <div class="row justify-content-center">
        <div class="d-flex justify-content-end gap-2 mb-4">
            <a href="/post.jsp" class="btn btn-danger">Back</a>
        </div>
        <div class="card shadow-sm mb-4" style="max-width: 700px; margin: auto;">
            <img src="/file/get?id=<%=post.getImage().getId()%>"
                 class="card-img-top"
                 alt="Image not found"
                 style="width: 100%; height: auto; max-height: 300px; object-fit: contain;">
            <div class="card-body">
                <span><strong>Title:</strong> <%= post.getTitle()%></span>
                <span><strong>Description:</strong> <%= post.getDescription() %></span>
            </div>

            <form action="/comment" method="post">
                <div class="d-flex align-items-center gap-2">
                    <input type="text" class="form-control" name="content" placeholder="Enter comment"
                           style="width: 200px;">
                    <button class="btn btn-danger">Send</button>
                </div>
            </form>
        </div>

        <div class="comments mt-4" style="max-width: 700px; margin: auto;">
            <h5 class="text-center mb-4">Comments:</h5>

            <% for (Comment comment : post.getComments()) { %>
            <div class="card mb-3 shadow-sm">
                <div class="card-body">
                    <h6 class="card-subtitle mb-2 text-muted">
                        <strong><%= comment.getUser().getLastName() %>:</strong>
                    </h6>
                    <p class="card-text"><%= comment.getContent() %>
                    </p>
                    <p class="text-end text-secondary" style="font-size: 0.9em;">
                        <%= comment.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) %>
                    </p>
                </div>
            </div>
            <% } %>
        </div>


    </div>
</div>

</body>
</html>
