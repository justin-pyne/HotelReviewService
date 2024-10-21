package hotelapp;

import java.time.LocalDate;

public class ReviewWithFrequency implements Comparable<ReviewWithFrequency> {
    private final Review review;
    private final int frequency;

    public ReviewWithFrequency(Review review, int frequency) {
        this.review = review;
        this.frequency = frequency;
    }

    public LocalDate getReviewDate() {
        return review.getDate();
    }

    public String getReviewId() {
        return review.getReviewId();
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public int compareTo(ReviewWithFrequency o) {
        int comp = Integer.compare(o.getFrequency(), this.getFrequency());
        if (comp != 0) {
            return comp;
        }
        int dateComp = o.getReviewDate().compareTo(this.getReviewDate());
        if (dateComp != 0) {
            return dateComp;
        }
        return this.getReviewId().compareTo(o.getReviewId());
    }

    @Override
    public String toString() {
        return frequency + System.lineSeparator() + review.toString();
    }
}
