package hotelapp;

import java.time.LocalDate;

public class Review {
    private final String hotelId;
    private final String reviewId;
    private final double rating;
    private final String reviewTitle;
    private final String reviewText;
    private final String userName;
    private final LocalDate date;

    public Review(String hotelId, String reviewId, double rating, String reviewTitle, String reviewText, String userName, String date) {
        this.hotelId = hotelId;
        this.reviewId = reviewId;
        this.rating = rating;
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.userName = userName;
        this.date = LocalDate.parse(date);
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public String getReviewId() {
        return reviewId;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "hotelId = " + hotelId + System.lineSeparator() +
                "reviewId = " + reviewId + System.lineSeparator() +
                "averageRating = " + rating + System.lineSeparator() +
                "title = " + reviewTitle + System.lineSeparator() +
                "reviewText = " + reviewText + System.lineSeparator() +
                "userNickname = " + userName + System.lineSeparator() +
                "submissionDate = " + date + System.lineSeparator() +
                "--------------------" + System.lineSeparator();
    }
}
