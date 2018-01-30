package com.netcracker.DAO.datamodel;

import com.netcracker.DAO.entity.Corps;
import com.netcracker.DAO.entity.Reviews;

import java.util.List;

/**
 * Created by user on 15.01.2018.
 */

public interface ReviewsDAO {
    void saveReviews(Reviews reviews);

    List<Reviews> findAllReviews();

    Reviews findReviewsById(int id);

    void deleteReviewsById(int id);
}
