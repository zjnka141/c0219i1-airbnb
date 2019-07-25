package codegym.airbnb.web.controller;

import codegym.airbnb.dao.dto.HouseDTO;
import codegym.airbnb.dao.entity.House;
import codegym.airbnb.services.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/houses")
public class HouseController {
    @Autowired
    private HouseService houseService;


    @PostMapping("")
    public ResponseEntity<HouseDTO> createHouse(@RequestBody HouseDTO houseDTO) {
        houseService.save(houseDTO);
        return ResponseEntity.ok(houseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HouseDTO> getHouse(@PathVariable("id") int id) {
        HouseDTO houseDTO = houseService.getHouseById(id);
        if (houseDTO != null) {
            return ResponseEntity.ok(houseDTO);
        }
        return ResponseEntity.ok(null);
    }

    @GetMapping("/list")
    public List<HouseDTO> listHouse() {
        List<HouseDTO> houseDTOS = houseService.getHouseList();
        return houseDTOS;
    }

    @GetMapping(value = "", params = {"page", "size"})
    public Page<House> listHouse(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<House> houses = houseService.getHouses(PageRequest.of(page, size));
        return houses;
    }

    @PutMapping("updateStatus/{id}")
    public ResponseEntity<?> updateStatusOfHouse(@PathVariable("id") Integer id, @RequestBody String status) {
        houseService.updateStatusOfHouse(id, status);
        HouseDTO houseDTO = houseService.getHouseById(id);
        return ResponseEntity.ok(houseDTO);
    }



}
