package Model;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.sql.SQLException;

@WebListener
public class WebInitialization implements ServletContextListener, HttpSessionListener {
    public static int booking_num;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        rooms hotelRooms = null;
        try {
            hotelRooms = new rooms("myDatabase");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ServletContext sc = servletContextEvent.getServletContext();
        sc.setAttribute("hotelRooms", hotelRooms);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        User currentUser = new User("myDatabase");
        session.setAttribute("currentUser", currentUser);
        booking_num = 1;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}