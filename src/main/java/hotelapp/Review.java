package hotelapp;

import java.util.Date;

public class Review {
    private String hotelId;
    private String reviewId;
    private String rating;
    private String reviewTitle;
    private String reviewText;
    private String userName;
    private Date date;

    public Review(String hotelId, String reviewId, String rating, String reviewTitle, String reviewText, String userName, Date date) {
        this.hotelId = hotelId;
        this.reviewId = reviewId;
        this.rating = rating;
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.userName = userName;
        this.date = date;
    }

    public String getReviewId() {
        return reviewId;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Review{" +
                "hotelId='" + hotelId + '\'' +
                ", reviewId='" + reviewId + '\'' +
                ", rating='" + rating + '\'' +
                ", reviewTitle='" + reviewTitle + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", userName='" + userName + '\'' +
                ", date=" + date +
                '}';
    }
}
