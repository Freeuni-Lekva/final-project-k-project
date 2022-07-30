package Controller;

import Application.src.main.java.Model.rooms;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
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
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}