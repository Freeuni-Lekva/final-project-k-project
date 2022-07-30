package Controller;

import Model.hotelRoom;
import Model.rooms;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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

        rooms rooms = null;
        try {
            rooms = new rooms("myDatabase");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList<hotelRoom> tmp = null;
        try {
            tmp = rooms.availableRooms(room_type,room_view,check_in,check_out);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(tmp.size() == 0){
            request.getRequestDispatcher("unsuccessful_reservation.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("user_information.jsp").forward(request, response);
        }
    }
}