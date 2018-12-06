package com.example.CourseBookingSystem.repositories.CourseRepository;

import com.example.CourseBookingSystem.models.Course;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom{


    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Course> findAllCoursesWithRating(int rating){
        List<Course> results = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Course.class);
            cr.add(Restrictions.eq("rating", rating));
            results = cr.list();
        }catch (HibernateException ex){
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return results;
    }

    @Transactional
    public List<Course> findAllCoursesForCustomer(Long customerID){
        List<Course> results = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            // SELECT * FROM COURSES
            Criteria cr = session.createCriteria(Course.class);

            // Specify that it's the bookings we're interested in
            cr.createAlias("bookings", "bookingAlias");

            // For the customer attached to each booking
//            cr.createAlias("bookingAlias.customer", "customerObject");

            // check if the customerObject id the same as the given ID
            cr.add(Restrictions.eq("bookingAlias.customer.id", customerID));

            results = cr.list();

        } catch (HibernateException ex){
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return results;
    }



} // REPO END
