package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.ReviewsDAO;
import com.netcracker.DAO.entity.Reserv;
import com.netcracker.DAO.entity.Reviews;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@Repository
public class ReviewsDAOImpl extends AbstractDAO implements ReviewsDAO {




    public ReviewsDAOImpl() {
    }

    @Override
    public void saveReviews(Reviews reviews) {
        persist(reviews);

    }

    @Override
    public List<Reviews> findAllReviews() {
        Criteria criteria = getSession().createCriteria(Reviews.class);
        return (List<Reviews>) criteria.list();
    }

    @Override
    public Reviews findReviewsById(int id) {
        Criteria criteria = getSession().createCriteria(Reviews.class);
        criteria.add(Restrictions.eq("id", id));
        return (Reviews) criteria.uniqueResult();
    }

    @Override
    public void deleteReviewsById(int id) {

    }
}
