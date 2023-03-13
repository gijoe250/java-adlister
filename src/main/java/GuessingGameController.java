import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guess")
public class GuessingGameController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/guess.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int answer = 2;

        int guess = Integer.parseInt(request.getParameter("guess"));

        if (guess == answer){
            System.out.println("Correct!");
            response.sendRedirect(String.format("/correct?guess=%s", guess));
        }
        else {
            System.out.println("Incorrect :((");
            response.sendRedirect(String.format("/incorrect?guess=%s", guess));
        }

    }
}
