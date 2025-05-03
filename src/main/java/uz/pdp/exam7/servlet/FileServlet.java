package uz.pdp.exam7.servlet;

import uz.pdp.exam7.entity.AttachmentContent;
import uz.pdp.exam7.repo.AttachmentContentRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/file/get")
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer attachmentId = Integer.parseInt(req.getParameter("id"));
        AttachmentContent attachmentContent = AttachmentContentRepo.findByAttachmentId(attachmentId);
        resp.getOutputStream().write(attachmentContent.getContent());
    }
}
