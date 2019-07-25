package codegym.airbnb.dao.repository;

import codegym.airbnb.dao.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}