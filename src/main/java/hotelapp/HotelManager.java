package hotelapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelManager {
    private Map<String, Hotel> hotelMap = new HashMap<>();


    public HotelManager(List<Hotel> hotels) {
        for (Hotel hotel : hotels) {
            hotelMap.put(hotel.getHotelId(), hotel);
        }
    }

    public String findHotel(String hotelId){
        if(!hotelMap.containsKey(hotelId)) {
            throw new IllegalArgumentException();
        }
        return hotelMap.get(hotelId).toString();
    }
}
