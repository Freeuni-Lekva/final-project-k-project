package Model;

public class User {

    private String userName;
    private String userSurname;
    private String roomId;
    private String roomType;
    private String roomView;
    private String checkInDate;
    private String checkOutDate;
    private String mail;
    private String phoneNumber;

    public User() {
        this.userName = null;
        this.userSurname = null;
        this.roomId = null;
        this.roomType = null;
        this.roomView = null;
        this.checkInDate = null;
        this.checkOutDate = null;
        this.mail = null;
        this.phoneNumber = null;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
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
}