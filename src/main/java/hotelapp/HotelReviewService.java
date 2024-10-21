package hotelapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelReviewService {
    private HotelManager hotelManager;
    private ReviewManager reviewManager;
    /**
     *
     * Parse given arguments that contain paths to the hotel file and the reviews folder,
     * and load hotel and review data into the corresponding data structures.
     * Do not store data structures (maps) in this class and do not do the actual parsing in this class,
     * think of a better design that includes multiple classes / packages, so that this class can
     * delegate work to other classes.
     * @param args  Arguments can be given in the following format:
     *  -hotels pathToHotelFile -reviews pathToReviewsFolder
     *   or
     *  -reviews pathToReviewsFolder -hotels pathToHotelFile
     */
    public void loadData(String[] args) {
        Map<String, String> argsMap = new HashMap<>();

        if (args.length == 0) {
            System.out.println("Missing arguments.");
            return;
        }

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                if (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                    argsMap.put(args[i], args[i + 1]);
                    i++;
                } else {
                    System.out.println("Unexpected or missing value for flag:" + args[i]);
                    return;
                }
            } else {
                System.out.println("Unexpected argument: " + args[i]);
                return;
            }
        }
        JsonProcessor js = new JsonProcessor();
        if (argsMap.containsKey("-hotels")){
            List<Hotel> hotels = js.parseHotel(argsMap.get("-hotels"));
            this.hotelManager = new HotelManager(hotels);
        }

        if (argsMap.containsKey("-reviews")){
            List<Review> reviews = js.parseReviews(argsMap.get("-reviews"));
            this.reviewManager = new ReviewManager(reviews);
        }
    }

    /**
     * Process a given query and return the result as a string
     * @param query in one of the following formats:
     *              findHotel hotelId
     *              findReviews hotelId
     *              findWord word
     * @return String, the result of the query
     */
    public String processQuery(String query) {
        String[] queries = query.split(" ", 2);
        String method = queries[0];

        if (method.equals("findHotel") && queries.length == 2){
            return hotelManager.findHotel(queries[1]);
        } else if (method.equals("findReviews") && queries.length == 2){
            return reviewManager.findReviews(queries[1]);
        } else if (method.equals("findWord") && queries.length == 2){
            return reviewManager.findWord(queries[1]);
        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        // Assumes 4 program arguments are passed to main:
        // -hotels pathToHotelFile -reviews pathToReviewsFolder
        //    or
        //  -reviews pathToReviewsFolder -hotels pathToHotelFile
        // They can be specified in Run/Edit Configuration/Program Arguments
        HotelReviewService service = new HotelReviewService();
        try {
            service.loadData(args); // pass arguments to loadData
            System.out.println(service.processQuery("findHotel 10323"));
            // Test your code with different queries
            // You can also run the instructor's tests, but they are not sufficient,
            // so do your own testing too.

        }
        catch(Exception e) {
            System.out.println("Could not load data or process a query." + e.getMessage());
        }
    }

}
