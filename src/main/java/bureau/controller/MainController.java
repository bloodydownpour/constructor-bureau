package bureau.controller;

import bureau.domain.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/index.html")
public class MainController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        if(session != null) {
            User user = (User) session.getAttribute("session_user");
            if(user != null) {
                switch(user.getRole()) {
                    case CONSTRUCTOR -> resp.sendRedirect(req.getContextPath() + "/constructor/projects.html");
                    case MANAGER -> resp.sendRedirect(req.getContextPath() + "/manager/requests.html");
                    case CLIENT -> resp.sendRedirect(req.getContextPath() + "/client/requests.html");
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/login/form.html");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login/form.html");
        }
    }
}
