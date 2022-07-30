package Application.src.main.java.Model;

import java.sql.*;
import java.util.ArrayList;

public class rooms {
    private Connection dbCon;
    private int booking_num;
    public rooms(String name) throws SQLException {
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
        booking_num = 0;
    }

    private ArrayList<hotelRoom> getRooms() throws SQLException {
        ArrayList<hotelRoom> tmp = new ArrayList<>();
        String q = "SELECT * FROM mydatabase.hotel_rooms";
        PreparedStatement ps = dbCon.prepareStatement(q,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            hotelRoom p = new hotelRoom(rs.getInt(1),rs.getString(2),rs.getInt(3),
                    rs.getInt(4), rs.getInt(5), rs.getString(6),
                    rs.getString(7), rs.getString(8), rs.getString(9),
                    rs.getString(10));
            tmp.add(p);
        }
        return tmp;
    }

    public ArrayList<hotelRoom> preferences(String type, String view) throws SQLException {
        ArrayList<hotelRoom> tmp = new ArrayList<>();
        ArrayList<hotelRoom> rooms = getRooms();
        for (hotelRoom roomTmp : rooms) {
            if ((roomTmp.getRoomType().equals(type) || type.equals("")) &&
                    (roomTmp.getView().equals(view) || view.equals(""))) {
                tmp.add(roomTmp);
            }
        }
        return tmp;
    }

    public ArrayList<hotelRoom> availableRooms(String type, String view, String in, String out) throws SQLException {
        ArrayList<hotelRoom> res = preferences(type, view);
        ArrayList<hotelRoom> tmp = new ArrayList<>();
        String q = "SELECT * From mydatabase.bookings WHERE check_in_date >= ? and check_out_date <= ?";
        PreparedStatement ps = dbCon.prepareStatement(q,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ps.setDate(1,Date.valueOf(in));
        ps.setDate(2,Date.valueOf(out));
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            hotelRoom p = new hotelRoom(rs.getInt(1),rs.getString(2),rs.getInt(3),
                    rs.getInt(4), rs.getInt(5), rs.getString(6),
                    rs.getString(7), rs.getString(8), rs.getString(9),
                    rs.getString(10));
            tmp.add(p);
        }
        res.removeIf(tmp::contains);
        return res;
    }

    public void checkIn(String personId, int roomId, String in, String out, String includes) throws SQLException {
        String query = "INSERT INTO mydatabase.bookings VALUES(?,?,?,?,?,?,?);";
        PreparedStatement ps = dbCon.prepareStatement(query);
        ps.setInt(1, booking_num);
        ps.setInt(2,roomId);
        ps.setString(3,personId);
        ps.setDate(4,Date.valueOf(in));
        ps.setDate(5,Date.valueOf(out));
        // price
        //total price

        ps.executeUpdate();
    }

    public void checkOut(int userId) throws SQLException {
        String q = "DELETE FROM mydatabase.users WHERE user_id = ?";
        PreparedStatement ps = dbCon.prepareStatement(q,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ps.setInt(1,userId);
        ps.executeUpdate();
    }
}
