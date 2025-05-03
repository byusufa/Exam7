package uz.pdp.exam7.servlet;

import jakarta.persistence.EntityManager;
import uz.pdp.exam7.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static uz.pdp.exam7.config.MyListener.EMF;

@WebServlet("/check/code")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");
        Integer code = (Integer) session.getAttribute("code");
        Integer userCode = Integer.parseInt(req.getParameter("userCode"));
        if (code.equals(userCode)) {
            try (
                    EntityManager entityManager = EMF.createEntityManager();
            ) {
                entityManager.getTransaction().begin();
                entityManager.persist(user);
                entityManager.getTransaction().commit();
                resp.sendRedirect("/post.jsp");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else{
            resp.sendRedirect("/login.jsp");
        }


    }
}
