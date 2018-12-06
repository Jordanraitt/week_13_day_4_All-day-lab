package com.example.CourseBookingSystem.controllers;

import com.example.CourseBookingSystem.models.Customer;
import com.example.CourseBookingSystem.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(value = "/course/{id}")
    public List<Customer> findAllCustomerForACourse(@PathVariable Long id) {
        return customerRepository.findAllCustomerForACourse(id);
    }

    @GetMapping(value = "/town/{townName}/course/{courseID}")
    public List<Customer> customerCourseTown(@PathVariable String townName, @PathVariable Long courseID){
        // can do upper/lowercase thing here for speed
        return customerRepository.findAllCustomersInGivenTownForGivenCourse(townName, courseID);
    }

    @GetMapping(value= "/town/{town}/age/{age}/course/{course}")
    public List<Customer> customerAgeTownCourse(@PathVariable String town, @PathVariable int age, @PathVariable Long course){
        return customerRepository.findAllCustomersOverAgeInGivenTownForGivenCourse(town, age, course);
    }
}
