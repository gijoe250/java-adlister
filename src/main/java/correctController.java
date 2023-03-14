import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/correct")
public class correctController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int guess = Integer.parseInt(request.getParameter("guess"));
        request.setAttribute("answer", guess);
        request.setAttribute("correct", "Correct!");
        request.getRequestDispatcher("/answer.jsp").forward(request, response);
    }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        int guess = Integer.parseInt(request.getParameter("guess"));
//        request.setAttribute("answer", guess);
//        request.setAttribute("correct", "Correct!");
//        request.getRequestDispatcher("/answer.jsp").forward(request, response);
//    }
}
