package uz.pdp.exam7.servlet;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import lombok.SneakyThrows;
import uz.pdp.exam7.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordRepeat = req.getParameter("passwordRepeat");
        if (password.equals(passwordRepeat)) {
            User user = new User(firstName, lastName, email, password,"USER");
            Map<String, String> errors = new HashMap<>();
            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Set<ConstraintViolation<User>> validate = validatorFactory.getValidator().validate(user);
            for (ConstraintViolation<User> violation : validate) {
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }

            if (!errors.isEmpty()) {
                req.setAttribute("errors", errors);
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
                return;
            } else {
                req.getSession().setAttribute("currentUser", user);
                Random random = new Random();
                int code = random.nextInt(9000) + 1000;
                req.getSession().setAttribute("code", code);
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "465");
                properties.put("mail.smtp.ssl.enable", "true");
                properties.put("mail.smtp.auth", "true");

                String userName = "buriev.y.a@gmail.com";
                String userPassword = "yifieybcumpacseh";

                Session session = getSession(properties, userName, userPassword);

                Message message = new MimeMessage(session);
                message.setSubject("Your code:");
                message.setText(code + "");
                message.setFrom(new InternetAddress(userName));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
                Transport.send(message);
                resp.sendRedirect("/code.jsp");
            }

        } else {
            resp.sendRedirect("/register.jsp");
        }
    }

    private static Session getSession(Properties properties, String userName, String password) {
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });
    }
}
