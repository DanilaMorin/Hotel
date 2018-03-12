package com.netcracker.DAO.implementation;

import com.netcracker.DAO.datamodel.AbstractDAO;
import com.netcracker.DAO.datamodel.ReviewsDAO;
import com.netcracker.DAO.entity.Reviews;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
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
            persist(reviews);
    }

    @Override
    public List<Reviews> findAllReviews() throws FatalError {
        try {
        Criteria criteria = getSession().createCriteria(Reviews.class);
        return (List<Reviews>) criteria.list();
    } catch (Exception ex) {
        ex.printStackTrace();
        throw new FatalError("base is not responding");
    }
    }

    @Override
    public Reviews findReviewsById(int id) throws EntityNotFound, FatalError {
        try {
            Criteria criteria = getSession().createCriteria(Reviews.class);
            criteria.add(Restrictions.eq("id", id));
            Reviews reviews = (Reviews) criteria.uniqueResult();
            if(reviews == null) throw new EntityNotFound("NoReviews");
            return reviews;
        }catch (EntityNotFound ex){
            throw new EntityNotFound(ex.getMessage());
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw  new FatalError("base is not responding");
        }
    }

    @Override
    public boolean deleteReviewsById(int id) throws FatalError {
        try {

            Query query = getSession().createQuery("DELETE  Reviews as res\n" +
                    " WHERE res.id = :id ");
            query.setInteger("id", id);
            int n = query.executeUpdate();
            if(n > 0) return true;
            else return false;
        }catch (Exception ex){
            ex.printStackTrace();
            throw new FatalError("base is not responding");
        }
    }
}
