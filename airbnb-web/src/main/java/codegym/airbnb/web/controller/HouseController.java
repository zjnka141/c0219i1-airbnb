package codegym.airbnb.web.controller;


import codegym.airbnb.dao.dto.HouseDTO;
import codegym.airbnb.services.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/houses")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @PostMapping("")
    public ResponseEntity<HouseDTO> createHouse(@RequestBody HouseDTO houseDTO) {
        houseService.save(houseDTO);
        return ResponseEntity.ok(houseDTO);
    }
}
