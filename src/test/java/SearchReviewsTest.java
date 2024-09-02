import hotelapp.HotelReviewService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SearchReviewsTest {
    private static String[] args;
    private static HotelReviewService hotelReviewService;

    @Test
    public void searchReviewsSmallFile() {
        String[] args = ArgUtil.prepareArgsSmallDataset();
        hotelReviewService = new HotelReviewService();
        hotelReviewService.loadData(args);
        String res = hotelReviewService.processQuery("findReviews 25622");
        assertNotNull(res);
        StringBuilder sbExpected = new StringBuilder();
        sbExpected.append("hotelId = 25622" + System.lineSeparator() +
                          "reviewId = 57b717a44751ca0b791823b2" + System.lineSeparator() +
                          "averageRating = 4.0" + System.lineSeparator() +
                          "title = Room too small" + System.lineSeparator() +
                          "reviewText = Great location, but the room is too small" + System.lineSeparator() +
                          "userNickname = Xiaofeng" + System.lineSeparator() +
                          "submissionDate = 2015-03-04" + System.lineSeparator() +
                        "--------------------" + System.lineSeparator());
        sbExpected.append("hotelId = 25622" + System.lineSeparator() +
                        "reviewId = 23d756a64672vr2gwegyhqw4" + System.lineSeparator() +
                        "averageRating = 5.0" + System.lineSeparator() +
                        "title = Great deal" + System.lineSeparator() +
                        "reviewText = Loved the neighborhood, very lively" + System.lineSeparator() +
                        "userNickname = Chris" + System.lineSeparator() +
                        "submissionDate = 2014-09-05" + System.lineSeparator() +
                        "--------------------" + System.lineSeparator());
        sbExpected.append("hotelId = 25622" + System.lineSeparator() +
                        "reviewId = 92rlnlvnabuwbf256jsf20fj" + System.lineSeparator() +
                        "averageRating = 3.0" + System.lineSeparator() +
                        "title = Overpriced" + System.lineSeparator() +
                        "reviewText = Good location, but very expensive" + System.lineSeparator() +
                        "userNickname = Alicia" + System.lineSeparator() +
                        "submissionDate = 2014-09-05" + System.lineSeparator() +
                        "--------------------" + System.lineSeparator());
        String expected = sbExpected.toString().replace("\r\n", "\n");
        res = res.replace("\r\n", "\n");
        assertEquals(expected.trim(), res.trim());
    }

    @Test
    public void searchReviewsLargerFile() {
        String[] args = ArgUtil.prepareArgsStandardDataset(); // From -hotels, -reviews folders
        hotelReviewService = new HotelReviewService();
        hotelReviewService.loadData(args);
        String res = hotelReviewService.processQuery("findReviews 150946");
        assertNotNull(res);
        //System.out.println(res);
        StringBuilder sb = new StringBuilder();
        sb.append("hotelId = 150946" + System.lineSeparator() +
                "reviewId = 576d839399fac30b8311b38b" + System.lineSeparator() +
                "averageRating = 4.0" + System.lineSeparator() +
                "title = New hotel close to Union Square. Great location!" + System.lineSeparator() +
                "reviewText = Got checked in early with a room upgrade. Good breakfast great service with a great location. " + System.lineSeparator() +
                "userNickname = Leah" + System.lineSeparator() +
                "submissionDate = 2016-06-24" + System.lineSeparator() +
                "--------------------" + System.lineSeparator());

        sb.append("hotelId = 150946" + System.lineSeparator() +
                "reviewId = 5754befb630b760b7cb60b8b" + System.lineSeparator() +
                "averageRating = 5.0" + System.lineSeparator() +
                "title = Highly recommend a stay at this hotel." + System.lineSeparator() +
                "reviewText = The staff was nice. The hotel was clean. Breakfast was great each morning. Close to shopping, food, transportation, and touring." + System.lineSeparator() +
                "userNickname = Dr Phil" + System.lineSeparator() +
                "submissionDate = 2016-06-06" + System.lineSeparator() +
                "--------------------" + System.lineSeparator());

        sb.append("hotelId = 150946" + System.lineSeparator() +
                "reviewId = 573885f6fd62b709fce5ba67" + System.lineSeparator() +
                "averageRating = 5.0" + System.lineSeparator() +
                "title = Nice hotel convenient location " + System.lineSeparator() +
                "reviewText = This was a very nice hotel in the heart of\r\nUnion Square. Staff was very friendly and facility very clean. Room was a little small but well appointed." + System.lineSeparator() +
                "userNickname = jJoe" + System.lineSeparator() +
                "submissionDate = 2016-05-15" + System.lineSeparator() +
                "--------------------" + System.lineSeparator());

        sb.append("hotelId = 150946" + System.lineSeparator() +
                "reviewId = 56ef0e2e6ae639097a90ca90" + System.lineSeparator() +
                "averageRating = 4.0" + System.lineSeparator() +
                "title = " + System.lineSeparator() +
                "reviewText = I liked the hotel, close to everything.\r\nThe neighborhood isnt so pretty though and noisy but this hotel is the best in the area." + System.lineSeparator() +
                "userNickname = " + System.lineSeparator() +
                "submissionDate = 2016-03-20" + System.lineSeparator() +
                "--------------------" + System.lineSeparator());

        sb.append("hotelId = 150946" + System.lineSeparator() +
                "reviewId = 56eda2c9b800f7097acb584b" + System.lineSeparator() +
                "averageRating = 3.0" + System.lineSeparator() +
                "title = Tiny new hotel tucked away inside an old building" + System.lineSeparator() +
                "reviewText = I stayed here during GDC 2016. The hotel had just opened - it was so new that they didn't yet have permanent signage, and I had trouble finding the place because I wasn't looking for the temporary signage inside the window. The continental breakfast included hot eggs and meat, although the quality was just barely enjoyable. Overall it was clean and new, but no-frills. Perfect for a trip where you want a clean and comfortable room downtown, but won't be spending much time in the hotel." + System.lineSeparator() +
                "userNickname = Jason" + System.lineSeparator() +
                "submissionDate = 2016-03-19" + System.lineSeparator() +
                "--------------------" + System.lineSeparator());

        sb.append("hotelId = 150946" + System.lineSeparator() +
                "reviewId = 56cc561903df4a09818ffadc" + System.lineSeparator() +
                "averageRating = 3.0" + System.lineSeparator() +
                "title = Beware of double charging your credit card" + System.lineSeparator() +
                "reviewText = Paid Expedia for hotel + flight.  A few days after checking out I noticed a charge for $628.64 from Holiday Inn Express.  I was double charged for the room.  I called Expedia and they said it was not their fault and to call the hotwl.  Called Holiday Inn Express Union Square and spoke with Marcelo who told me that someone made a mistake and it should have been charged to third party \"Expedia\", but only th manager Raj can fix it.  He said he would email Raj to fix it and call me back.  Raj never has called so I filled a dispute with my credit card company.  Neither Expedia nor Holiday Inn Express seem to want to fix the problem...stressful to the customer and poor customer service!!" + System.lineSeparator() +
                "userNickname = Darrin" + System.lineSeparator() +
                "submissionDate = 2016-02-23" + System.lineSeparator() +
                "--------------------" + System.lineSeparator());
        String expected = sb.toString().replace("\r\n", "\n");
        res = res.replace("\r\n", "\n");
        assertEquals(expected.trim(), res.trim());
    }
}
