package com.netcracker.DAO.datamodel;

import com.netcracker.DAO.entity.Reviews;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;

import java.util.List;

/**
 * Created by user on 15.01.2018.
 */

public interface ReviewsDAO {
    void saveReviews(Reviews reviews);

    List<Reviews> findAllReviews() throws FatalError;

    Reviews findReviewsById(int id) throws EntityNotFound, FatalError;

    boolean deleteReviewsById(int id) throws FatalError;
}
