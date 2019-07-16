package codegym.airbnb.services.service.impl;


import codegym.airbnb.dao.dto.HouseDTO;
import codegym.airbnb.dao.entity.House;
import codegym.airbnb.dao.repository.HouseRepository;
import codegym.airbnb.services.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepository houseRepository;
    @Override
    public List<House> findAllByDeletedIsFalse() {
        return houseRepository.findAllByDeletedIsFalse();
    }

    @Override
    public void save(HouseDTO houseDTO) {
        House house = new House();

        house.setName(houseDTO.getName());
        house.setAddress(houseDTO.getAddress());
        house.setDeleted(Boolean.FALSE);
        house.setDescribe(houseDTO.getDescribe());
        house.setNumberOfBathrooms(houseDTO.getNumberOfBathrooms());
        house.setNumberOfBedrooms(houseDTO.getNumberOfBedrooms());
        house.setTypeHouse(houseDTO.getTypeHouse());
        house.setPriceByNight(houseDTO.getPriceByNight());
        house.setTypeRoom(houseDTO.getPriceByNight());
        house.setArea(houseDTO.getArea());
        house.setPriceByMonth(houseDTO.getPriceByMonth());
//        house.setAccount(houseDTO.getAccount());
        house.setImage(houseDTO.getImage());
        house.setStatus(houseDTO.getStatus());

         houseRepository.save(house);

    }
}
