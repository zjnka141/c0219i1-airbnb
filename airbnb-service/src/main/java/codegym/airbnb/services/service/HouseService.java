package codegym.airbnb.services.service;


import codegym.airbnb.dao.dto.HouseDTO;
import codegym.airbnb.dao.entity.House;

import java.util.List;

public interface HouseService {
    List<House> findAllByDeletedIsFalse();
    void save(HouseDTO houseDTO);
}