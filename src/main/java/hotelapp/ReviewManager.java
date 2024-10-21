package hotelapp;

import java.util.*;

public class ReviewManager {
    private Map<String, List<Review>> reviewMap = new HashMap<>();
    private Map<String, TreeSet<ReviewWithFrequency>> invertedIndex = new HashMap<>();


    public ReviewManager(List<Review> reviews) {
        for (Review review : reviews) {
            if (!reviewMap.containsKey(review.getHotelId())) {
                reviewMap.put(review.getHotelId(), new ArrayList<>());
            }
            reviewMap.get(review.getHotelId()).add(review);
            invertedIndexReview(review);
        }
    }

    public String findReviews(String hotelId){
        if (!reviewMap.containsKey(hotelId)) {
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
        word = word.toLowerCase();
        if (!invertedIndex.containsKey(word)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (ReviewWithFrequency reviewWithFrequency : invertedIndex.get(word)) {
            result.append(reviewWithFrequency.toString());
        }
        return result.toString();
    }

    private void invertedIndexReview(Review review) {
        String[] words = review.getReviewText().toLowerCase().split("[,;!\\. ]");

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (String word : wordCount.keySet()) {
            int frequency = wordCount.get(word);
            ReviewWithFrequency reviewWithFrequency = new ReviewWithFrequency(review, frequency);

            invertedIndex.computeIfAbsent(word, v -> new TreeSet<>()).add(reviewWithFrequency);
        }
    }

}
