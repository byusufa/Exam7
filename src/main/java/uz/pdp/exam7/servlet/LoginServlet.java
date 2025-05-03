package uz.pdp.exam7.servlet;

import jakarta.persistence.EntityManager;
import uz.pdp.exam7.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static uz.pdp.exam7.config.MyListener.EMF;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (EntityManager entityManager = EMF.createEntityManager()) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            User foundUser = null;
            try {
                foundUser = entityManager.createQuery("from User where email = :email and password = :password", User.class)
                        .setParameter("email", email)
                        .setParameter("password", password)
                        .getSingleResult();
            } catch (jakarta.persistence.NoResultException e) {
                resp.sendRedirect("/login.jsp?error=invalid");
                return;
            }

            req.getSession().setAttribute("currentUser", foundUser);
            if ("ADMIN".equals(foundUser.getRole())) {
                resp.sendRedirect("/admin.jsp");
            } else if ("USER".equals(foundUser.getRole())) {
                resp.sendRedirect("/post.jsp");
            } else {
                resp.sendRedirect("/login.jsp?error=unauthorized");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Xatolik yuz berdi.");
        }


    }
}
