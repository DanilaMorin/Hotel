package com.netcracker.services;

import com.netcracker.DAO.entity.Reviews;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */

public interface ReviewsService {

    void saveReviews(Reviews reviews);

    List<Reviews> findAllReviews() throws FatalError;

    Reviews findReviewsById(int id) throws FatalError, EntityNotFound;

    int deleteReviewsById(int id) throws FatalError;

}
