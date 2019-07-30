package codegym.airbnb.services.service.impl;

import codegym.airbnb.dao.dto.BookingDTO;
import codegym.airbnb.dao.entity.Booking;
import codegym.airbnb.dao.repository.BookingRepository;
import codegym.airbnb.services.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void save(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setBirthday(bookingDTO.getBirthday());
        booking.setCheckIn(bookingDTO.getCheckIn());
        booking.setCheckOut(bookingDTO.getCheckOut());
        booking.setFullName(bookingDTO.getFullName());
        booking.setGender(bookingDTO.getGender());
        booking.setPhone(bookingDTO.getPhone());
        booking.setRelationship(bookingDTO.getRelationship());
        booking.setAmount(bookingDTO.getAmount());
        booking.setDesciptionBookingHouse(bookingDTO.getDesciptionBookingHouse());
        booking.setDeleted(Boolean.FALSE);

        bookingRepository.save(booking);

    }

}
