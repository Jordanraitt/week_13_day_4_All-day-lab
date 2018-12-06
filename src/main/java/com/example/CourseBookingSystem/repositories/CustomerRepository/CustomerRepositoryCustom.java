package com.example.CourseBookingSystem.repositories.CustomerRepository;

import com.example.CourseBookingSystem.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

    List<Customer> findAllCustomerForACourse(Long courseID);

    List<Customer> findAllCustomersInGivenTownForGivenCourse(String townName, Long courseID);

    List<Customer> findAllCustomersOverAgeInGivenTownForGivenCourse(String townName, int age, Long courseID);
}
