package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Booking", urlPatterns = {"/Booking"})
public class Booking extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // request.getRequestDispatcher("index.jsp").forward(request, response);
        String check_in = request.getParameter("check_in");
        String check_out = request.getParameter("check_out");
        String room_type = request.getParameter("chooseroom");
        String room_view = request.getParameter("chooseview");
        String pool_and_gym = request.getParameter("choosepoolandgym");
        String includes_pool_gym_meal = "INCLUDES ";
        if (pool_and_gym != null) {
            includes_pool_gym_meal += "POOL GYM";
        }
        String meal = request.getParameter("choosemeal");
        if (meal != null) {
            includes_pool_gym_meal += " MEAL";
        }

        // Checking if this type of room is free.
        // if (free) -> request.getRequestDispatcher("user_information.jsp").forward(request, response);
        // else -> request.getRequestDispatcher("unsuccessful_reservation.jsp").forward(request, response);
    }
}