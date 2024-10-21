package hotelapp;

import java.util.*;

public class ReviewManager {
    private Map<String, List<Review>> reviewMap = new HashMap<>();
    private Map<String, TreeSet<ReviewWithFrequency>> invertedIndex = new HashMap<>();


    public ReviewManager(List<Review> reviews) {
        for(Review review : reviews) {
            if(!reviewMap.containsKey(review.getHotelId())) {
                reviewMap.put(review.getHotelId(), new ArrayList<>());
            }
            reviewMap.get(review.getHotelId()).add(review);
            invertedIndexReview(review);
        }
    }

    public String findReviews(String hotelId){
        if(!reviewMap.containsKey(hotelId)) {
            throw new IllegalArgumentException();
        }

        List<Review> reviews = reviewMap.get(hotelId);

        reviews.sort((r1, r2) -> {
           int comp = r2.getDate().compareTo(r1.getDate());
           if (comp == 0) {
               return r1.getReviewId().compareTo(r2.getReviewId());
           }
           return comp;
        });

        StringBuilder result = new StringBuilder();

        for (Review review : reviews) {
            result.append(review.toString());
        }
        return result.toString();
    }

    public String findWord(String word){

    }

    private void invertedIndexReview(Review review) {

    }

}
