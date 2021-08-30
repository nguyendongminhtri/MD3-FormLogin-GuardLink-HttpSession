package chinh.anh.controller;

import chinh.anh.model.Users;
import chinh.anh.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("form-login/login.jsp");
        dispatcher.forward(request,response);
        HttpSession session = request.getSession();
        System.out.println("check session user  -->"+session.getAttribute("user"));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserServiceImpl userService = new UserServiceImpl();
        Users users = userService.findByUsernameAndPassword(username,password);
        String destPage = "form-login/login.jsp";
        if(users !=null){
            HttpSession session = request.getSession();
            session.setAttribute("user", users);
            System.out.println("Check session user luc login ==>"+session.getAttribute("user"));
            destPage = "form-login/profile.jsp";
        }else {
            String message = "Login failed! Please check username/password";
            request.setAttribute("message", message);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request,response);
    }
}
