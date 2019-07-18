package codegym.airbnb.web.controller;


import codegym.airbnb.dao.dto.HouseDTO;
import codegym.airbnb.services.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{id}")
    public  ResponseEntity<HouseDTO> getHouse(@PathVariable("id")int id) {
        HouseDTO houseDTO=houseService.getHouseById(id);
        if(houseDTO!=null) {
            return ResponseEntity.ok(houseDTO);
        }
        return ResponseEntity.ok(null);
    }
    @GetMapping("/list")
    public List<HouseDTO> listHouse() {
        List<HouseDTO> houseDTOS = houseService.getHouseList();
        return houseDTOS;
    }

    @PutMapping("updateStatus/{id}")
    public ResponseEntity<?> updateStatusOfHouse(@PathVariable("id")Integer id) {
        houseService.updateStatusOfHouse(id);
        HouseDTO houseDTO =houseService.getHouseById(id);
        return ResponseEntity.ok(houseDTO);
    }

}
