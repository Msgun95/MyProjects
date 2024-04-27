package myproject.ecommerse.controller;

import lombok.RequiredArgsConstructor;
import myproject.ecommerse.model.Review;
import myproject.ecommerse.service.imp.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;


    @PostMapping("/customer/{customerId}/item/{itemId}")
    public ResponseEntity<Review> createReview(@RequestBody Review review,
                                               @PathVariable int customerId,
                                               @PathVariable int itemId){
        Review addreview = reviewService.addReview(review, customerId, itemId);
        return ResponseEntity.ok(addreview);
    }
    @GetMapping
    public ResponseEntity<List<Review>> retrieveAllReview (){
        return ResponseEntity.ok(reviewService.getAllReviews());

    }
    @GetMapping("/{id}")
    public ResponseEntity<Review> retrieveReviewById(@PathVariable int id){
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }


}
