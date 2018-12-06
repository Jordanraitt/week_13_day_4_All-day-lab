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

            // SPECIFY THAT IT'S THE BOOKING THAT WE'RE INTERESTED IN
            cr.createAlias("bookings", "bookingAlias");

            // For the customer attached to that booking
            cr.createAlias("bookingAlias.customer", "customer");

            // check if it's the same as the given ID
            cr.add(Restrictions.eq("customer.id", customerID));

            results = cr.list();
        } catch (HibernateException ex){
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return results;
    }



} // REPO END
