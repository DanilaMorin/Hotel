package com.netcracker.services;

import com.netcracker.DAO.entity.Reviews;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */

public interface ReviewsService {

    void saveReviews(Reviews reviews);

    List<Reviews> findAllReviews();

    Reviews findReviewsById(int id);

    void deleteReviewsById(int id);

}
