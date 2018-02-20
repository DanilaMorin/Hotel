package com.netcracker.services.servicesImpl;

import com.netcracker.DAO.datamodel.ReviewsDAO;
import com.netcracker.DAO.entity.Reviews;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@Service("reviewsService")
@Transactional
public class ReviewsServiceImpl implements ReviewsService {
    @Autowired
    ReviewsDAO reviewsDAO;
    @Override
    public void saveReviews(Reviews reviews) {
        reviewsDAO.saveReviews(reviews);
    }

    @Override
    public List<Reviews> findAllReviews() throws FatalError {

        return reviewsDAO.findAllReviews();
    }

    @Override
    public Reviews findReviewsById(int id) throws FatalError, EntityNotFound {
        return reviewsDAO.findReviewsById(id);
    }

    @Override
    public int deleteReviewsById(int id) throws FatalError {
        return reviewsDAO.deleteReviewsById(id);

    }
}
