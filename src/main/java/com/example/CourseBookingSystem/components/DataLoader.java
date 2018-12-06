package com.example.CourseBookingSystem.components;

import com.example.CourseBookingSystem.models.Booking;
import com.example.CourseBookingSystem.models.Course;
import com.example.CourseBookingSystem.models.Customer;
import com.example.CourseBookingSystem.repositories.BookingRepository.BookingRepository;
import com.example.CourseBookingSystem.repositories.CourseRepository.CourseRepository;
import com.example.CourseBookingSystem.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        //Course/s

        Course python = new Course("Python Course", "Aberdeen", 2);
        courseRepository.save(python);

        Course ruby = new Course("Ruby Course", "Dundee", 2);
        courseRepository.save(ruby);

     //-----------------------------------------
        //Customers

        Customer rick = new Customer("Rick", "London", 40);
        customerRepository.save(rick);

        Customer morty = new Customer("Morty", "Ipswich", 15);
        customerRepository.save(morty);

     //-----------------------------------------
        //Bookings

        Booking bookingAlpha = new Booking("05/12/2018", python, rick);
        bookingRepository.save(bookingAlpha);

        Booking bookingBeta = new Booking("05/12/2018", python, morty);
        bookingRepository.save(bookingBeta);
    }
}
