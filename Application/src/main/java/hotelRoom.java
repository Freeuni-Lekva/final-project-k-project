package Application.src.main.java;

import java.util.Date;

public class hotelRoom {
    private int roomId;
    private int pricePerDay;
    private int priceWithMeal;
    private int priceWithPoolAndGym;
    private String roomType;
    private boolean hasBalcony;
    private boolean hasFreeWifi;
    private boolean hasAirConditioning;
    private boolean hasTelevision;
    private String view;
    private boolean isBooked;
    private Date checkInDate;
    private Date checkOutDate;
    private String isBookedBy;

    public hotelRoom(int id, String type, int price, int withMeal, int withPoolAndGym,
                     String airConditioning, String tv, String balcony, String view,
                     String wifi, String isBooked, Date checkIn, Date checkOut, String bookedBy){
        this.roomId = id;
        this.pricePerDay = price;
        this.priceWithMeal = withMeal;
        this.priceWithPoolAndGym = withPoolAndGym;
        this.roomType = type;
        this.hasAirConditioning = airConditioning.equals("+");
        this.hasTelevision = tv.equals("+");
        this.hasFreeWifi = wifi.equals("+");
        this.hasBalcony = balcony.equals("+");
        this.view = view;
        this.isBooked = isBooked.equals("+");
        this.checkInDate = checkIn;
        this.checkOutDate = checkOut;
        this.isBookedBy = bookedBy;
    }

    public boolean isBooked(){
        return isBooked;
    }

    public boolean hasAirConditioning(){
        return hasAirConditioning;
    }

    public boolean hasFreeWifi(){
        return hasFreeWifi;
    }

    public boolean hasBalcony(){
        return hasBalcony;
    }

    public boolean hasTelevision(){
        return hasTelevision;
    }

    public String getRoomType(){
        return roomType;
    }

    public int getPrice(String included){
        if(included.equals("INCLUDES MEAL")) return priceWithMeal;
        if(included.equals("INCLUDES POOL AND GYM")) return priceWithPoolAndGym;
        if(included.equals("INCLUDES MEAL, POOL AND GYM")){
            return priceWithPoolAndGym + priceWithMeal - pricePerDay;
        }
        return pricePerDay;
    }

    public String getView(){
        return view;
    }

    public Date getCheckInDate(){
        return checkInDate;
    }

    public Date getCheckOutDate(){
        return checkOutDate;
    }

    public String isBookedBy(){
        return isBookedBy;
    }
}
