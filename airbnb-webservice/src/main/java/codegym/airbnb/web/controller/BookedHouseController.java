package codegym.airbnb.web.controller;

import codegym.airbnb.dao.entity.BookedHouse;
import codegym.airbnb.dao.repository.BookedHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/booked-houses")
public class BookedHouseController {
    @Autowired
    BookedHouseRepository bookedHouseRepository;


    @GetMapping("")
    public List<BookedHouse> getAllBookedHouse() {
        return bookedHouseRepository.findAll();
    }


}
