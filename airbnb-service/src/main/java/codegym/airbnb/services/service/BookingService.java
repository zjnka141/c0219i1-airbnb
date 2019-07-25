package codegym.airbnb.services.service;

import codegym.airbnb.dao.dto.BookingDTO;

public interface BookingService {
    void save(BookingDTO bookingDTO);
}
