package com.example.CourseBookingSystem.repositories.BookingRepository;

import com.example.CourseBookingSystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCustom {
}
