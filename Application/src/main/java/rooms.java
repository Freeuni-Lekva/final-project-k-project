package Application.src.main.java;

import java.sql.*;
import java.util.ArrayList;

public class rooms {
    private Connection dbCon;
    private ArrayList<hotelRoom> rooms;
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
        this.rooms = getRooms();
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
                    rs.getString(10), rs.getString(11), rs.getDate(12),
                    rs.getDate(13),rs.getString(14));
            tmp.add(p);
        }
        return tmp;
    }

    public ArrayList<hotelRoom> getAllRoom(){
        return rooms;
    }

    public ArrayList<hotelRoom> getRoomWithPreferences(String type, String view){
        ArrayList<hotelRoom> tmp = new ArrayList<>();
        for(int i = 0; i < rooms.size(); i++){
            hotelRoom roomTmp = rooms.get(i);
            if(roomTmp.equals(type) && roomTmp.getView().equals(view)){
                tmp.add(roomTmp);
            }
        }
        return tmp;
    }


}
