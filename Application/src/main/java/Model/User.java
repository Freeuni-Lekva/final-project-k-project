package Model;

public class User {
    private String roomId;
    private String roomType;
    private String roomView;
    private String checkInDate;
    private String checkOutDate;
    private String mail;
    private String phoneNumber;

    public User(String room_id, String room_type, String room_view, String check_in_date, String check_out_date) {
        this.roomId = room_id;
        this.roomType = room_type;
        this.roomView = room_view;
        this.checkInDate = check_in_date;
        this.checkOutDate = check_out_date;
        this.mail = null;
        this.phoneNumber = null;
    }

    public String getRoomId() {
        return roomId;
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

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}