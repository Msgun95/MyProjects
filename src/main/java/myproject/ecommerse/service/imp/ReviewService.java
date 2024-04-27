package myproject.ecommerse.service.imp;

import lombok.RequiredArgsConstructor;
import myproject.ecommerse.exception.CustomerNotFoundException;
import myproject.ecommerse.exception.ItemNotFoundException;
import myproject.ecommerse.model.Customer;
import myproject.ecommerse.model.Item;
import myproject.ecommerse.model.Review;
import myproject.ecommerse.repository.CustomerRepo;
import myproject.ecommerse.repository.ItemsRepo;
import myproject.ecommerse.repository.ReviewRepo;
import myproject.ecommerse.service.IReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ReviewService implements IReviewService {

    private final ReviewRepo reviewRepo;
    private final ItemsRepo itemsRepo;
    private final CustomerRepo customerRepo;
    @Override
    public Review addReview(Review review, int customerId, int itemId){

        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(()->new CustomerNotFoundException("Customer with the Id "+ customerId+"does not exist"));
//        if(customer!=null & review.getReviewId() !=null){
            review.setCustomer(customer);

           Item item = itemsRepo.findById(itemId)
                   .orElseThrow(()->
                    new ItemNotFoundException(" Item not exist"));
           review.setItem(item);


//        }

        return reviewRepo.save(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    @Override
    public Review getReviewById(int id) {
        return reviewRepo.findById(id).orElseThrow(()->new RuntimeException("no comment yet"));
    }

    @Override
    public Review deleteReview(int id) {
        return null;
    }
}
