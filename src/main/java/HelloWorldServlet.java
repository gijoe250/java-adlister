import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
    public int count = 0;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        String reset = req.getParameter("reset");
        if(name == null){
            res.getWriter().println("<h1>Hello World!<h1>");
        }
        else {
            res.getWriter().println("<h1>Hello " + name + "!<h1>");
        }
        if (reset != null){
            count = 0;
        }
        else {
            res.getWriter().println(count);
            count++;
        }
    }
}
