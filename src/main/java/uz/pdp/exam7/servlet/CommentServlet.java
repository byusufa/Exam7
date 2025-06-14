package uz.pdp.exam7.servlet;

import jakarta.persistence.EntityManager;
import uz.pdp.exam7.entity.Comment;
import uz.pdp.exam7.entity.Post;
import uz.pdp.exam7.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static uz.pdp.exam7.config.MyListener.EMF;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (
                EntityManager entityManager = EMF.createEntityManager();

        ) {
            HttpSession session = req.getSession();
            User currentUser = (User) session.getAttribute("currentUser");
            Post post = (Post) session.getAttribute("post");
            String content = req.getParameter("content");

            if (currentUser == null || post == null) {
                resp.sendRedirect("/login.jsp");
                return;
            }

            User persistentUser = entityManager.find(User.class, currentUser.getId());
            if (persistentUser == null) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user.");
                return;
            }

            Comment comment = new Comment();
            comment.setPost(post);
            comment.setUser(persistentUser);
            comment.setContent(content);

            entityManager.getTransaction().begin();
            entityManager.persist(comment);
            entityManager.getTransaction().commit();

            resp.sendRedirect("/comment.jsp?id=" + post.getId());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
