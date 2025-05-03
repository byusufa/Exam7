package uz.pdp.exam7.config;

import uz.pdp.exam7.entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class Filter extends HttpFilter {
    List<String> openPaths = new ArrayList<>(
            List.of(
                    "/login.jsp",
                    "/register.jsp"
            )
    );

    List<String> adminPaths = new ArrayList<>(
            List.of(
                    "/admin.jsp",
                    "/addPost.jsp",
                    "/post/add",
                    "/file/get"
            )
    );

    List<String> userPath = new ArrayList<>(
            List.of(
                    "/post.jsp",
                    "/code.jsp",
                    "/comment.jsp",
                    "/comment",
                    "/check/code",
                    "/file/get"
            )
    );

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (openPaths.contains(req.getRequestURI())) {
            chain.doFilter(req, res);
            return;
        }

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");
        if (user == null) {
            res.sendRedirect("/login.jsp");
            return;
        } else {
            if (adminPaths.contains(req.getRequestURI()) && user.getRole().equals("ADMIN")) {
                chain.doFilter(req, res);

            } else if (userPath.contains(req.getRequestURI()) && user.getRole().equals("USER")) {
                chain.doFilter(req, res);

            } else {
                res.sendRedirect("/login.jsp");
                return;
            }
        }
    }
}

