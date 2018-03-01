package com.netcracker.bakend;

import com.netcracker.DAO.entity.Reviews;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 04.02.2018.
 */
@RestController
@RequestMapping("rest/reviews")
public class RestReviewsControler {

    @Autowired
    ReviewsService reviewsService;
    @PostMapping("/add")
    ResponseEntity saveReviews(@RequestBody Reviews reviews){
        try {
            reviews.setText(Validation.parseString1(reviews.getText()));
            reviewsService.saveReviews(reviews);
            return new ResponseEntity<String>("Uploaded", HttpStatus.OK);
        }
        catch (DataIntegrityViolationException ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>("Such an object already exists", HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            System.out.println("Error");
            ex.printStackTrace();
            return new ResponseEntity<String>("Not Added",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
    @GetMapping("/getAll")
    ResponseEntity findAllReviews(){
        try {
            List<Reviews> list = reviewsService.findAllReviews();
            return new ResponseEntity<List<Reviews>>(list,HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    };
    @PostMapping("/getById")
    ResponseEntity findReviewsById(int id){
        try {
            Reviews reviews =reviewsService.findReviewsById(id);
            return new ResponseEntity<Reviews>(reviews,HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (EntityNotFound entityNotFound) {
            entityNotFound.printStackTrace();
            return new ResponseEntity<String>(entityNotFound.getMessage(), HttpStatus.NOT_FOUND);
        }
    };
    @DeleteMapping("/delById")
    ResponseEntity deleteReviewsById(int id){
        int n = 0;
        try {
            n = reviewsService.deleteReviewsById(id);
            Boolean b = false;
            if (n > 0) b = true;
            return new ResponseEntity<Boolean>(b,HttpStatus.OK);
        } catch (FatalError fatalError) {
            fatalError.printStackTrace();
            return new ResponseEntity<String>(fatalError.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    };
}
