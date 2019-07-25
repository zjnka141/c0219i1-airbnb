package codegym.airbnb.web.controller;


import codegym.airbnb.dao.dto.HouseDTO;
import codegym.airbnb.dao.entity.House;
import codegym.airbnb.services.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    @GetMapping(value = "", params = {"page", "size","search","numBed","typeBed"})
    public Page<House> listHouse(@RequestParam("page") int page,
                                 @RequestParam("size") int size,
                                 @RequestParam("search") String name,
                                 @RequestParam("min") int min,
                                 @RequestParam("max") int max,
                                 @RequestParam("numBed") List<Integer> numBed,
                                 @RequestParam("typeBed") List<String> typeBed
                                 ) {
        System.out.println(numBed);
        System.out.println(typeBed);

        Page<House> houses = houseService.getHouses(PageRequest.of(page,size),name, min, max, numBed, typeBed);
        return houses;
    }

    @PutMapping("updateStatus/{id}")
    public ResponseEntity<?> updateStatusOfHouse(@PathVariable("id")Integer id, @RequestBody String status) {
        houseService.updateStatusOfHouse(id, status);
        HouseDTO houseDTO =houseService.getHouseById(id);
        return ResponseEntity.ok(houseDTO);
    }

}
