package com.example.CourseBookingSystem.repositories.CustomerRepository;

import com.example.CourseBookingSystem.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom{

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Customer> findAllCustomerForACourse(Long courseID){
        List<Customer> results = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Customer.class);

            cr.createAlias("bookings", "bookingAlias");

            cr.createAlias("bookingAlias.course", "courseObject");

            cr.add(Restrictions.eq("courseObject.id", courseID));

            results = cr.list();
        }catch (HibernateException ex){
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return results;
    }

    @Transactional
    public List<Customer> findAllCustomersInGivenTownForGivenCourse(String townName, Long courseID) {
        List<Customer> results = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.add(Restrictions.eq("town", townName));

            cr.createAlias("bookings", "bookingAlias");

            cr.add(Restrictions.eq("bookingAlias.course.id", courseID));

            results = cr.list();

        }catch (HibernateException ex){
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return results;
    }

    @Transactional
    public List<Customer> findAllCustomersOverAgeInGivenTownForGivenCourse(String townName, int age, Long courseID) {
        List<Customer> results = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.add(Restrictions.eq("town", townName));
            cr.add(Restrictions.gt("age", age));

            cr.createAlias("bookings", "bookingAlias");

            cr.add(Restrictions.eq("bookingAlias.course.id", courseID));

            results = cr.list();

        }catch (HibernateException ex){
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return results;
    }
}
