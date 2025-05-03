package uz.pdp.exam7.servlet;

import jakarta.persistence.EntityManager;
import uz.pdp.exam7.entity.Attachment;
import uz.pdp.exam7.entity.Post;
import uz.pdp.exam7.repo.AttachmentRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;

import static uz.pdp.exam7.config.MyListener.EMF;

@WebServlet("/post/add")
@MultipartConfig
public class PostAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (
                EntityManager entityManager = EMF.createEntityManager();
        ) {
            Part image = req.getPart("image");
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            Attachment imageAttachment = AttachmentRepo.saveFile(image.getSubmittedFileName(), image.getInputStream().readAllBytes());
            Post post = new Post(title, description, imageAttachment, new ArrayList<>());
            entityManager.getTransaction().begin();
            entityManager.persist(post);
            entityManager.getTransaction().commit();
            resp.sendRedirect("/admin.jsp");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
