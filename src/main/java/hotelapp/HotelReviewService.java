package hotelapp;

public class HotelReviewService {
    // Add variables as needed - must be non-static
    // Add additional classes - do not put all the code in this one class, this would be a bad design

    /**
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
       // FILL IN CODE to load data from json files

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
        // FILL IN CODE to process three types of queries:
        // findHotel hotelId
        // findReviews hotelId
        // findWord word
        // Refer to the project description for details

        return "";
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
            System.out.println("Could not load data or process a query.");
        }
    }

}
