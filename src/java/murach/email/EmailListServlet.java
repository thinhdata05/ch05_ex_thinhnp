package murach.email;

import java.io.*;  
import javax.servlet.*;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.*;  
@WebServlet("/survey")
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName  = request.getParameter("lastName");
        String email     = request.getParameter("email");

        String url;
        if (firstName == null || firstName.isEmpty() ||
            lastName == null || lastName.isEmpty() ||
            email == null || email.isEmpty()) {
            
            // thiếu dữ liệu thì quay lại form
            request.setAttribute("message", "Please fill out all three text boxes.");
            url = "/index.html";
        } else {
            // đủ dữ liệu thì chuyển qua thanks.jsp
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("email", email);
            url = "/thanks.jsp";
        }

        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }
}
