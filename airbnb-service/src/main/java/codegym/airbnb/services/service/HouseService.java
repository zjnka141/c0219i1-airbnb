package codegym.airbnb.services.service;


import codegym.airbnb.dao.dto.HouseDTO;
import codegym.airbnb.dao.entity.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HouseService {
    List<House> findAllByDeletedIsFalse();

    void save(HouseDTO houseDTO);

    HouseDTO getHouseById(int id);

    List<HouseDTO> getHouseList();

    Page<House> getHouses(Pageable pageable, String name, int min, int max,List<Integer> numBed, List<String> typeBed);

    void updateStatusOfHouse(int id, String status);
}
