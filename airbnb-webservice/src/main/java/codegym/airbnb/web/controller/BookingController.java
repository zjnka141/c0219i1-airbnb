package codegym.airbnb.web.controller;

import codegym.airbnb.dao.dto.BookingDTO;
import codegym.airbnb.services.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("")
    public ResponseEntity<BookingDTO> createHouse(@RequestBody BookingDTO bookingDTO) {
        bookingService.save(bookingDTO);
        return ResponseEntity.ok(bookingDTO);
    }
}
