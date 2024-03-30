package com.example.fitzoneadmin;

public class TrainerReviewList {
    private String rating, review,name,image;
    public TrainerReviewList( String rating,String name,String image) {
        this.rating =rating;
        this.name =name;
        this.image =image;

    }

    public String getReview() {return review;}
    public String getRating() {return rating;}

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setReview(String review) {
        this.review = review;
    }
}