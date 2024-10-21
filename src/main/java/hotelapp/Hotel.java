package hotelapp;

public class Hotel {

    private final String name;
    private final String hotelId;
    private final String longitude;
    private final String latitude;
    private final String address;
    private final String city;


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

    @Override
    public String toString() {
        return "hotelName = " + name + System.lineSeparator() +
                "hotelId = " + hotelId + System.lineSeparator() +
                "latitude = " + latitude + System.lineSeparator() +
                "longitude = " + longitude + System.lineSeparator() +
                "address = " + address + ", " + city + System.lineSeparator();
    }
}
