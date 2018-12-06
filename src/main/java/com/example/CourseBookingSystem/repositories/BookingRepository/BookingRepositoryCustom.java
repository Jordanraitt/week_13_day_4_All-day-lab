package com.example.CourseBookingSystem.repositories.BookingRepository;

import com.example.CourseBookingSystem.models.Booking;

import java.util.List;

public interface BookingRepositoryCustom {

    List<Booking> findAllBookingsOnGivenDate(String date);
}
