package com.example.CourseBookingSystem.repositories.BookingRepository;

import com.example.CourseBookingSystem.models.Booking;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class BookingRepositoryImpl implements BookingRepositoryCustom{

    @Autowired
    EntityManager entityManager;


    @Transactional
    public List<Booking> findAllBookingsOnGivenDate(String date){
        List<Booking> results = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Booking.class);

            cr.add(Restrictions.eq("date", date));
            results = cr.list();

        } catch (HibernateException ex){
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return results;
        }
}

