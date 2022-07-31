package Model;

import java.sql.*;

public class User {

    private String userName;
    private String userSurname;
    private hotelRoom room;
    private String roomType;
    private String roomView;
    private String checkInDate;
    private String checkOutDate;
    private String mail;
    private String phoneNumber;
    private String preferences;
    private Connection dbCon;

    public User(String name) {
        this.userName = null;
        this.userSurname = null;
        this.room = null;
        this.roomType = null;
        this.roomView = null;
        this.checkInDate = null;
        this.checkOutDate = null;
        this.mail = null;
        this.phoneNumber = null;
        this.preferences = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbCon = DriverManager.getConnection(
                    "jdbc:mysql://localhost",
                    "root",
                    "mkulo");
            Statement useDbStm = dbCon.createStatement();
            useDbStm.execute("USE " + name);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addUser() throws SQLException {
        String q = "INSERT INTO mydatabase.users(user_mail, user_name, user_surname, room_number) VALUES(?,?,?,?)";
        PreparedStatement ps = dbCon.prepareStatement(q,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ps.setString(1,mail);
        ps.setString(2,userName);
        ps.setString(3,userSurname);
        ps.setInt(4,room.getID());
        ps.executeUpdate();
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public hotelRoom getRoomId() {
        return room;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomView() {
        return roomView;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public String getMail() {
        return mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public void setRoomId(hotelRoom room) {
        this.room = room;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRoomView(String roomView) {
        this.roomView = roomView;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
}