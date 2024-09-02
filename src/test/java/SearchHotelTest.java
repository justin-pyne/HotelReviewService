import hotelapp.HotelReviewService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchHotelTest {
    private static String[] args;
    private static HotelReviewService hotelReviewService;

    @Test
    public void searchByHotelId25622() {
        String[] args = ArgUtil.prepareArgsSmallDataset();
        hotelReviewService = new HotelReviewService();
        hotelReviewService.loadData(args);
        String res = hotelReviewService.processQuery("findHotel 25622");
        assertNotNull(res);
        assertTrue(res.contains("25622"));
        assertTrue(res.contains("Hilton San Francisco Union Square"));
        assertTrue(res.contains("333 O'Farrell St."));
        assertTrue(res.contains("San Francisco"));
        assertTrue(res.contains("37.786160"));
        assertTrue(res.contains("-122.410180"));
    }

    @Test
    public void searchByHotelId10323() {
        String[] args = ArgUtil.prepareArgsStandardDataset();
        hotelReviewService = new HotelReviewService();
        hotelReviewService.loadData(args);
        String res = hotelReviewService.processQuery("findHotel 10323");
        assertNotNull(res);
        assertTrue(res.contains("10323"));
        assertTrue(res.contains("Hilton Garden Inn San Francisco/Oakland Bay Bridge"));
        assertTrue(res.contains("1800 Powell Street"));
        assertTrue(res.contains("Emeryville"));
        assertTrue(res.contains("37.837773"));
        assertTrue(res.contains("-122.298142"));
    }

    @Test
    public void searchByHotelId23774() {
        String[] args = ArgUtil.prepareArgsStandardDataset();
        hotelReviewService = new HotelReviewService();
        hotelReviewService.loadData(args);
        String res = hotelReviewService.processQuery("findHotel 23774");
        assertNotNull(res);
        assertTrue(res.contains("23774"));
        assertTrue(res.contains("Hyatt Regency San Francisco"));
        assertTrue(res.contains("5 Embarcadero Center"));
        assertTrue(res.contains("San Francisco"));
        assertTrue(res.contains("37.793720"));
        assertTrue(res.contains("-122.396440"));
    }

}
