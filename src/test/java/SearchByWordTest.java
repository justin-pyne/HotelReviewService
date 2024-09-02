import hotelapp.HotelReviewService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SearchByWordTest {
    private static String[] args;
    private static HotelReviewService hotelReviewService;

    @Test
    public void searchReviewsSmallFile() {
        String[] args = ArgUtil.prepareArgsSmallDataset();
        hotelReviewService = new HotelReviewService();
        hotelReviewService.loadData(args);
        String res = hotelReviewService.processQuery("findWord location");
        assertNotNull(res);
        StringBuilder sbExpected = new StringBuilder();
        sbExpected .append("1" + System.lineSeparator() +
                "hotelId = 25622" + System.lineSeparator() +
                "reviewId = 57b717a44751ca0b791823b2" + System.lineSeparator() +
                "averageRating = 4.0" + System.lineSeparator() +
                "title = Room too small" + System.lineSeparator() +
                "reviewText = Great location, but the room is too small" + System.lineSeparator() +
                "userNickname = Xiaofeng" + System.lineSeparator() +
                "submissionDate = 2015-03-04" + System.lineSeparator() +
                "--------------------" + System.lineSeparator());
        sbExpected.append("1" + System.lineSeparator() +
                "hotelId = 25622" + System.lineSeparator() +
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
        assertEquals(sbExpected.toString().trim(), res.trim());
    }

    @Test
    public void searchReviewsLargerFile() {
        String[] args = ArgUtil.prepareArgsStandardDataset(); // From -hotels, -reviews folders
        hotelReviewService = new HotelReviewService();
        hotelReviewService.loadData(args);
        String res = hotelReviewService.processQuery("findWord dog");
        assertNotNull(res);
        //System.out.println(res);
        StringBuilder sb = new StringBuilder();
        sb.append("4" + System.lineSeparator() + // frequency of the word in this review text
                "hotelId = 225819" + System.lineSeparator() +
                "reviewId = 574fa3a6021cc109df10d39c" + System.lineSeparator() +
                "averageRating = 3.0" + System.lineSeparator() +
                "title = Great concept poor execution. " + System.lineSeparator() +
                "reviewText = My normal go to when traveling to San Francisco is the Mark Hopkins. This time I wanted to try something new a bit more hip then old school. The staff is amazing, kind, knowledgable and overall good people. The room not so great, office chair super dirty as pictured below the vents were super dusty. The only reason I looked was because my allergies were so agitated it had to be something in the room.  I travel with my hypoallergenic dog when we asked for a dog bed it came covered in dog hair. Mind you my dog doesn't shed and she refused to lay on that bed. Lastly No room service only breakfastI guess thats where it counts but was disappointing. " + System.lineSeparator() +
                "userNickname = " + System.lineSeparator() +
                "submissionDate = 2016-06-02" + System.lineSeparator() +
                "--------------------" + System.lineSeparator());

        sb.append("2" + System.lineSeparator() +
                "hotelId = 23838" + System.lineSeparator() +
                "reviewId = 56a1184aeb9755099412f0b7" + System.lineSeparator() +
                "averageRating = 5.0" + System.lineSeparator() +
                "title = Wonderful experience!" + System.lineSeparator() +
                "reviewText = Great stay!  From our initial experience of arrival and dropping off our car to the valet (a very friendly gentlemen welcomed us and took care of the car quickly), to a pleasant gentlemen at the desk who answered all of our questions \u0026 checked us in quickly (we did have reservations for our 3 day stay), to other hotel staff who were all smiles and acknowledged us as we arrived and got our luggage to the elevator.  Beautiful room, great views of the waterfront and arriving and departing flight at SFO.\r\nSurprisingly quiet, giving the proximity to the airport.  Clean, spacious, and well-appointed comfy room.   Our experiences at Hangar Steak for both dinner and breakfast were wonderful.  Expertly prepared steaks (tried the filet.  Best I\u0027ve EVER eaten). My wife had the free-range chicken with root veggies.  She thought it was AMAZING.  Local produce was used, and it\u0027s SO fresh!!   The breakfast buffet was also beyond awesome.   Also, we appreciated having a dog relief station right out back for our service dog, complete with baggies.  All staff members ROCK!  Awesome folks, truly!  Marriot just GETS the concept of hospitality. We\u0027ll be staying here again very soon!" + System.lineSeparator() +

                "userNickname = Shannon" + System.lineSeparator() +
                "submissionDate = 2016-01-21" + System.lineSeparator() +
                "--------------------" + System.lineSeparator());

        sb.append("2" + System.lineSeparator() + // frequency: how many times "dog" appears in this review text
                "hotelId = 200649" + System.lineSeparator() +
                "reviewId = 562548ec47aaef094a82737d" + System.lineSeparator() +
                "averageRating = 1.0" + System.lineSeparator() +
                "title = Don't book this hotel" + System.lineSeparator() +
                "reviewText = There were some dog wastes in front of our room door, and we did not know where were they come from. We asked front desk to help for cleaning up around 10 pm, but no one came to clean up until morning. The most awful thing is that they CHARGED us $75 for the dog wastes when we checked out. TERRIBLE!" + System.lineSeparator() +
                "userNickname = " + System.lineSeparator() +
                "submissionDate = 2015-10-19" + System.lineSeparator() +
                "--------------------" + System.lineSeparator());

        sb.append("1" + System.lineSeparator() +
                "hotelId = 4705" + System.lineSeparator() +
                "reviewId = 57a8c6e9e40c4a0b28fde3fa" + System.lineSeparator() +
                "averageRating = 5.0" + System.lineSeparator() +
                "title = Nice room, nice beds, nice staff" + System.lineSeparator() +
                "reviewText = Very nice front desk staff.  Gave me upgrade room after I was placed in a room next to a dog whining.  " + System.lineSeparator() +
                "userNickname = kirsten" + System.lineSeparator() +
                "submissionDate = 2016-08-08" + System.lineSeparator() +
                "--------------------" + System.lineSeparator());

        sb.append("1" + System.lineSeparator() +
                "hotelId = 5830" + System.lineSeparator() +
                "reviewId = 5793d5a53a803a0b288f2525" + System.lineSeparator() +
                "averageRating = 4.0" + System.lineSeparator() +
                "title = Great for me and my dog!" + System.lineSeparator() +
                //"reviewText = Lovely, pet friendly hotel. The only complaint is the parking structure is the only place to park in the area, and they charge $25 for an overnight stay (I arrived at 11pm and left by 10am). I didn't ask what 2 nights would have cost... " +
                "reviewText = Lovely, pet friendly hotel. The only complaint is the parking structure is the only place to park in the area, and they charge $25 for an overnight stay (I arrived at 11pm and left by 10am). I didn't ask what 2 nights would have cost...\n" +
                        "Also, the tub/shower had nicks that weren't repaired, but being on the dog floor, I didn't mind.\n" +
                        "Everyone was friendly and helpful." + System.lineSeparator() +
                //"Also, the tub/shower had nicks that weren't repaired, but being on the dog floor, I didn't mind. Everyone was friendly and helpful." + System.lineSeparator() +
                "userNickname = Susan" + System.lineSeparator() +
                "submissionDate = 2016-07-23" + System.lineSeparator() +
                "--------------------" + System.lineSeparator());

        sb.append("1" + System.lineSeparator() +
                "hotelId = 26945" + System.lineSeparator() +
                "reviewId = 5786d9852c54c70b28dbd121" + System.lineSeparator() +
                "averageRating = 3.0" + System.lineSeparator() +
                "title = La Quinta Inn near SFO" + System.lineSeparator() +
                "reviewText = Mid-level hotel in significant need of upgrading.  Staff was friendly and helpful, and the free shuttle to/from SFO was very useful.  However, room was tiny and cramped and the walls were paper thin.  Had a barking dog in the next room and thank god it went to sleep late at night.  Not the worst hotel experience, but not the best." + System.lineSeparator() +
                "userNickname = Traveler" + System.lineSeparator() +
                "submissionDate = 2016-07-14" + System.lineSeparator() +
                "--------------------" + System.lineSeparator());

        sb.append("1" + System.lineSeparator() +
                "hotelId = 1606984" + System.lineSeparator() +
                "reviewId = 571980dbaf750809dae2c418" + System.lineSeparator() +
                "averageRating = 2.0" + System.lineSeparator() +
                "title = Up for a dance competition " + System.lineSeparator() +
                "reviewText = Hmnnn well the first room we didn't even get to the door as there was a loud barking dog next door , nope! Then the 2nd room only had one bed when we booked 2 queens for 4 of us. The third room was fine but really disappointed there wasn't even a cofee maker. The guy working was very nice. Trash outside when we first walked in was overflowing. Overall it was OK.  Would pay a bit more for something a bit nicer with full breakfast and a coffee pot! " + System.lineSeparator() +
                "userNickname = dance mom" + System.lineSeparator() +
                "submissionDate = 2016-04-22" + System.lineSeparator() +
                "--------------------" + System.lineSeparator());

        sb.append("1" + System.lineSeparator() +
                "hotelId = 7655" + System.lineSeparator() +
                "reviewId = 56afe64303bdc90980cd1c23" + System.lineSeparator() +
                "averageRating = 5.0" + System.lineSeparator() +
                "title = Great for family and including the pets" + System.lineSeparator() +
                "reviewText = Stay here yearly for the Cow Palace dog show and is very comfortable and convenient. Close to nearby shopping and BJ's , Red Lobster and many more places to eat. Breakfast is good and for the price a great deal." + System.lineSeparator() +
                "userNickname = " + System.lineSeparator() +
                "submissionDate = 2016-02-01" + System.lineSeparator() +
                "--------------------" + System.lineSeparator());

        sb.append("1" + System.lineSeparator() +
                "hotelId = 524164" + System.lineSeparator() +
                "reviewId = 55827028" + System.lineSeparator() +
                "averageRating = 4.0" + System.lineSeparator() +
                "title = Nice Hotel close to highway." + System.lineSeparator() +
                "reviewText = Overall the hotel was very satisfactory. It was close to the airport (10 minutes away) and to At&t Park (20 minutes). It was a dog friendly hotel so we brought our mutt. It has a nice walking trail by the water." + System.lineSeparator() +
                "userNickname = RAMIL" + System.lineSeparator() +
                "submissionDate = 2013-08-06" + System.lineSeparator() +
                "--------------------" + System.lineSeparator());
        //System.out.println(Arrays.toString(sb.toString().getBytes()));
        //System.out.println(Arrays.toString(res.getBytes()));
        String expected = sb.toString().replace("\r\n", "\n");
        res = res.replace("\r\n", "\n");
        assertEquals(expected.trim(), res.trim());
    }
}
