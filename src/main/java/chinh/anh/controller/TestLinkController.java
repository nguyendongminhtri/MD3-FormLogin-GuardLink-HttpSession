package chinh.anh.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.rmi.server.ServerCloneException;

@WebServlet("/link")
public class TestLinkController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if(action ==null){
            action = "";
        }
        switch (action){
            case "create":
                if(session.getAttribute("user")!=null){
                   response.sendRedirect("test-link/test.jsp");
                    break;
                } else {
                    response.sendRedirect("/login");
                    break;
                }
            default:
                response.sendRedirect("/login");
        }
    }
//    private void showFormCreate(HttpServletRequest request, HttpServletResponse response){
//        RequestDispatcher dispatcher = request.getRequestDispatcher("test-link/test.jsp");
//        try {
//            dispatcher.forward(request,response);
//        } catch (ServletException e){
//            e.printStackTrace();
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//    }
}
