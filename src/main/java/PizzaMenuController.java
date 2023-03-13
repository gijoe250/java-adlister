import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pizza-order")
public class PizzaMenuController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pizzaMenu.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String crust = request.getParameter("crust");
        String topping1 = request.getParameter("topping1");
        String topping2 = request.getParameter("topping2");
        String topping3 = request.getParameter("topping3");
        String address = request.getParameter("address");

        System.out.println();
        System.out.println(crust);
        System.out.println(topping1);
        System.out.println(topping2);
        System.out.println(topping3);
        System.out.println(address);
        // pass the value of the name variable to the view, and send the request
        // forward to the hello.jsp file
        request.setAttribute("crust", crust);
        request.setAttribute("topping1", topping1);
        request.setAttribute("topping2", topping2);
        request.setAttribute("topping3", topping3);
        request.setAttribute("address", address);
        request.getRequestDispatcher("/pizzaMenu.jsp").forward(request, response);
    }
}
