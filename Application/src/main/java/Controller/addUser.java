package Controller;

import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "addUser", urlPatterns = {"/addUser"})
public class addUser extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String mail = request.getParameter("mail");
        String phone_number = request.getParameter("phone_number");
        HttpSession currentSession = request.getSession();
        User currentUser = (User) currentSession.getAttribute("currentUser");

        // Adding name, surname, mail, phone_number to the users table.
        /*try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement stmt = conn.createStatement();
        }
        // Execute a query
        System.out.println("Inserting records into the table...");
        String sql = "INSERT INTO users VALUES (100, 'Zara', 'Ali', 18)";
        stmt.executeUpdate(sql);*/

        // Adding room_id, user_mail, check_in_date, check_out_date, price_per_day, total_price to the booking table.

        // After these two insertions:
        request.getRequestDispatcher("successful_reservation.jsp").forward(request, response);
    }
}