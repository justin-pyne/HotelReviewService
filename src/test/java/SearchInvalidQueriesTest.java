import hotelapp.HotelReviewService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SearchInvalidQueriesTest {
    private static String[] args;
    private static HotelReviewService hotelReviewService;

    @BeforeAll
    public static void setUp() {
        args = ArgUtil.prepareArgsStandardDataset();
        hotelReviewService = new HotelReviewService();
        hotelReviewService.loadData(args);
    }
    @Test
    public void testEmptyHotelQuery() {
        assertThrows(IllegalArgumentException.class, () -> {
            hotelReviewService.processQuery("findHotel");
        }); // processQuery must throw an IllegalArgumentException in this case
    }
    @Test
    public void testInvalidHotelIdQuery() {
        assertThrows(IllegalArgumentException.class, () -> {
            hotelReviewService.processQuery("findHotel 1");
        }); // processQuery must throw an IllegalArgumentException in this case
    }

    @Test
    public void testEmptyReviewQuery() {
        assertThrows(IllegalArgumentException.class, () -> {
            hotelReviewService.processQuery("findReviews");
        }); // processQuery must throw an IllegalArgumentException in this case
    }

    @Test
    public void testInvalidReviewQuery() {
        assertThrows(IllegalArgumentException.class, () -> {
            hotelReviewService.processQuery("findReviews 1");
        }); // processQuery must throw an IllegalArgumentException in this case
    }

    @Test
    public void testEmptyWordQuery() {
        assertThrows(IllegalArgumentException.class, () -> {
            hotelReviewService.processQuery("findWord");
        }); // processQuery must throw an IllegalArgumentException in this case
    }
}
