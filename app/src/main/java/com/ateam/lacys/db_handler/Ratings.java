package com.ateam.lacys.db_handler;

/**
 * Created by Valentin on 2/24/2015.
 */
public class Ratings
{
    //private variables
    private String reviewsID;
    private int starCount;
    private String productReview;
    private String reviews;

    //getters and setters
    public String getReviewsID() {
        return reviewsID;
    }

    public void setReviewsID(String reviewsID) {
        this.reviewsID = reviewsID;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public String getProductReview() {
        return productReview;
    }

    public void setProductReview(String productReview) {
        this.productReview = productReview;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }
}