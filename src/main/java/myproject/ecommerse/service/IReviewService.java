package myproject.ecommerse.service;

import myproject.ecommerse.model.Review;

import java.util.List;

public interface IReviewService {
    Review addReview(Review review);
    List<Review> getAllReviews();
    Review getReviewById(int id);
    Review deleteReview(int id);
}
