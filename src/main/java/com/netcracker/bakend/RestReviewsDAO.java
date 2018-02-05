package com.netcracker.bakend;

import com.netcracker.DAO.entity.Reviews;
import com.netcracker.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 04.02.2018.
 */
@RestController
@RequestMapping("/reviews")
public class RestReviewsDAO {

    @Autowired
    ReviewsService reviewsService;
    @PostMapping("/add")
    void saveReviews(Reviews reviews){
        reviewsService.saveReviews(reviews);
    };
    @GetMapping("/getAll")
    List<Reviews> findAllReviews(){
        return reviewsService.findAllReviews();
    };
    @PostMapping("/getById")
    Reviews findReviewsById(int id){
        return reviewsService.findReviewsById(id);
    };
    @DeleteMapping("/delById")
    boolean deleteReviewsById(int id){
        int n = reviewsService.deleteReviewsById(id);
        Boolean b = false;
        if (n > 0) b = true;
        return b;
    };
}
