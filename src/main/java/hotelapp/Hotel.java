package hotelapp;

public class Hotel {

    private String name;
    private String hotelId;
    private String longitude;
    private String latitude;
    private String address;
    private String city;


    public Hotel(String name, String hotelId, String longitude, String latitude, String address, String city) {
        this.name = name;
        this.hotelId = hotelId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.city = city;
    }

    public String getHotelId() {
        return hotelId;
    }
}
