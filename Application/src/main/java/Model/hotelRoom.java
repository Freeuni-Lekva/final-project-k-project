package Application.src.main.java.Model;


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

    public hotelRoom(int id, String type, int price, int withMeal, int withPoolAndGym,
                     String airConditioning, String tv, String balcony, String view,
                     String wifi){
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
}
