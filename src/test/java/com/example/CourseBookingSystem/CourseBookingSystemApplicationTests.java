package com.example.CourseBookingSystem;

import com.example.CourseBookingSystem.models.Booking;
import com.example.CourseBookingSystem.models.Course;
import com.example.CourseBookingSystem.models.Customer;
import com.example.CourseBookingSystem.repositories.BookingRepository.BookingRepository;
import com.example.CourseBookingSystem.repositories.CourseRepository.CourseRepository;
import com.example.CourseBookingSystem.repositories.CustomerRepository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseBookingSystemApplicationTests {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getCourseGivenARating(){
        List<Course> results = courseRepository.findAllCoursesWithRating(2);
    }

    @Test
    public void getAllCoursesForAGivenCustomer(){
	    List<Course> results = courseRepository.findAllCoursesForCustomer(1L);
    }

    @Test
    public void getAllCustomersForAGivenCourse(){
	    List<Customer> results = customerRepository.findAllCustomerForACourse(1L);
    }

    @Test
    public void getAllBookingsForGivenDate(){
	    List<Booking> results = bookingRepository.findAllBookingsOnGivenDate("05-12-2018");
    }

}
