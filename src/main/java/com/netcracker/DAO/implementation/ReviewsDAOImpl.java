package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.ReviewsDAO;
import com.netcracker.DAO.entity.Reviews;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 12345 on 30.01.2018.
 */
@Repository
public class ReviewsDAOImpl extends AbstractDAO implements ReviewsDAO  {




    public ReviewsDAOImpl() {
    }

    @Override
    public void saveReviews(Reviews reviews)  {
        try {
            persist(reviews);
        } catch (HibernateException e) {
            e.printStackTrace();
        }

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
    public int deleteReviewsById(int id) {
        Query query = getSession().createQuery("DELETE  Reviews as res\n" +
                " WHERE res.id = :id ");
        query.setInteger("id", id);
        int n =   query.executeUpdate();
        return n;
    }
}
