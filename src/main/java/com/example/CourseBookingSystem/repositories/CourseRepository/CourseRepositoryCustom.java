package com.example.CourseBookingSystem.repositories.CourseRepository;

import com.example.CourseBookingSystem.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {

    List<Course> findAllCoursesWithRating(int rating);
}
