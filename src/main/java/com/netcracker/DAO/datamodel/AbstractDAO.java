package com.netcracker.DAO.datamodel;

/**
 * Created by 12345 on 29.01.2018.
 */
import com.sun.xml.internal.ws.handler.HandlerException;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class AbstractDAO {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void persist(Object entity)  {getSession().persist(entity);
    }

    public void delete(Object entity){
        getSession().delete(entity);
    }

}
