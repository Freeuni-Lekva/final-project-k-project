package Controller;


import Model.hotelRoom;
import Model.rooms;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

// @WebServlet(name = "Booking", urlPatterns = {"/Booking"})
public class Booking extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.getRequestDispatcher("index.jsp").forward(request, response);

        String check_in = changeDateFormat(request.getParameter("check_in"));
        String check_out = changeDateFormat(request.getParameter("check_out"));

        String room_type = request.getParameter("choose_room");
        String room_view = request.getParameter("choose_view");

        System.out.println(check_in);

        String pool_and_gym = request.getParameter("choose_pool_and_gym");
        String includes_pool_gym_meal = "INCLUDES ";
        if (pool_and_gym != null) {
            includes_pool_gym_meal += "POOL GYM";
        }

        String meal = request.getParameter("choose_meal");
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
            assert rooms != null;
            tmp = rooms.availableRooms(room_type,room_view,check_in,check_out);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Checking if this type of room is free.
        // if (free) -> request.getRequestDispatcher("user_information.jsp").forward(request, response);
        assert tmp != null;
        if(tmp.size() == 0){
            // else -> request.getRequestDispatcher("unsuccessful_reservation.jsp").forward(request, response);
            request.getRequestDispatcher("unsuccessful_reservation.jsp").forward(request, response);
        }else{
            User newUser = (User) request.getSession().getAttribute("currentUser");
            newUser.setCheckInDate(check_in);
            newUser.setCheckOutDate(check_out);
            newUser.setRoomType(room_type);
            newUser.setRoomView(room_view);
            newUser.setPreferences(includes_pool_gym_meal);
            // newUser.setRoomId(room_id), room_id from the table.
            newUser.setRoomId(tmp.get(0));
            request.getRequestDispatcher("user_information.jsp").forward(request, response);
        }
    }

    private String changeDateFormat(String date){
        String tmp = "";
        String[] arrOfStr = date.split("/", 3);
        tmp += arrOfStr[2] + "-";
        tmp += arrOfStr[0] + "-";
        tmp += arrOfStr[1];
        return tmp;
    }
}