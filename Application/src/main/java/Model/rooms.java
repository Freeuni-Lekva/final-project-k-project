package Model;

import java.sql.*;
import java.util.ArrayList;

import static Model.WebInitialization.booking_num;

public class rooms {
    private Connection dbCon;
    public rooms(String name) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbCon = DriverManager.getConnection(
                    "jdbc:mysql://localhost",
                    "root",
                    "PurpleHyacinth-04");
            Statement useDbStm = dbCon.createStatement();
            useDbStm.execute("USE " + name);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<hotelRoom> getRooms() throws SQLException {
        ArrayList<hotelRoom> tmp = new ArrayList<>();
        String q = "SELECT * FROM myDatabase.hotel_rooms";
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
        ArrayList<hotelRoom> helper = preferences(type, view);
        ArrayList<hotelRoom> tmp = new ArrayList<>();
        // String q = "SELECT * From bookings WHERE check_in_date>=\"" + in + "\"and check_out_date<=\"" + out + "\";";
        String q = "SELECT * From myDatabase.bookings WHERE check_in_date>=? and check_out_date<=?;";
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
        ArrayList<hotelRoom> res = new ArrayList<>();
        for (int i = 0; i < helper.size(); i++){
            if(!tmp.contains(helper.get(i))){
                res.add(helper.get(i));
            }
        }
        return res;
    }

    // getParameter("picker"); String date = request.getParameter("datepicker");
    public void booking(String mail, int roomId, String in, String out, String included) throws SQLException {
        String query = "INSERT INTO myDatabase.bookings VALUES(?,?,?,?,?,?,?);";
        PreparedStatement ps = dbCon.prepareStatement(query);
        ps.setInt(1, booking_num);
        ps.setInt(2,roomId);
        ps.setString(3,mail);
        ps.setDate(4,Date.valueOf(in));
        ps.setDate(5,Date.valueOf(out));
        hotelRoom hr = getHotelRoom(roomId);
        ps.setInt(6,hr.getPrice(included));
        ps.setInt(7,0);
        ps.executeUpdate();
        booking_num += 1;
    }

    private hotelRoom getHotelRoom(int roomId) throws SQLException {
        String q = "SELECT * FROM hotel_rooms WHERE room_id = ?";
        PreparedStatement ps = dbCon.prepareStatement(q,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ps.setInt(1, roomId);
        ResultSet rs = ps.executeQuery();
        hotelRoom p = null;
        rs.next();
        p = new hotelRoom(rs.getInt(1),rs.getString(2),rs.getInt(3),
                rs.getInt(4), rs.getInt(5), rs.getString(6),
                rs.getString(7), rs.getString(8), rs.getString(9),
                rs.getString(10));
        return p;
    }

    public void checkOut(int mail) throws SQLException {
        String q = "DELETE FROM users WHERE user_mail = ?";
        PreparedStatement ps = dbCon.prepareStatement(q,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ps.setInt(1,mail);
        ps.executeUpdate();
    }
}
