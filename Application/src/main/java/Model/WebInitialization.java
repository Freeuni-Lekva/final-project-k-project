package Model;

<<<<<<< HEAD:Application/src/main/java/Model/WebInitialization.java
=======
import Model.User;
import Model.rooms;
>>>>>>> cd688b674ecf9243c5bf092b74588bc216c36a32:Application/src/main/java/Controller/WebInitialization.java

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
        User currentUser = new User();
        session.setAttribute("currentUser", currentUser);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}