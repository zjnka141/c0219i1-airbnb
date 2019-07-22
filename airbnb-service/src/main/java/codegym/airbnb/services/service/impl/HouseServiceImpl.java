package codegym.airbnb.services.service.impl;


import codegym.airbnb.dao.dto.HouseDTO;
import codegym.airbnb.dao.entity.House;
import codegym.airbnb.dao.repository.HouseRepository;
import codegym.airbnb.services.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepository houseRepository;

    @Override
    public List<House> findAllByDeletedIsFalse() {
        return houseRepository.findAllByDeletedIsFalse();
    }

    // fix
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
        house.setTypeRoom(houseDTO.getTypeRoom());
        house.setArea(houseDTO.getArea());
        house.setPriceByMonth(houseDTO.getPriceByMonth());
//        house.setAccount(houseDTO.getAccount());
        house.setImage(houseDTO.getImage());
        house.setStatus(houseDTO.getStatus());

        houseRepository.save(house);

    }

    @Override
    public HouseDTO getHouseById(int id) {
        House house = houseRepository.findAllByDeletedIsFalseAndIdIs(id);
        if (house != null) {
            HouseDTO houseDTO = new HouseDTO();
            houseDTO.setId(house.getId());
            houseDTO.setAddress(house.getAddress());
            houseDTO.setArea(house.getArea());
            houseDTO.setDescribe(house.getDescribe());
            houseDTO.setImage(house.getImage());
            houseDTO.setName(house.getName());
            houseDTO.setNumberOfBathrooms(house.getNumberOfBathrooms());
            houseDTO.setPriceByMonth(house.getPriceByMonth());
            houseDTO.setPriceByNight(house.getPriceByNight());
            houseDTO.setTypeHouse(house.getTypeHouse());
            houseDTO.setTypeRoom(house.getTypeRoom());
            houseDTO.setNumberOfBedrooms(house.getNumberOfBedrooms());
            houseDTO.setStatus(house.getStatus());

            return houseDTO;
        }
        return null;
    }

    @Override
    public List<HouseDTO> getHouseList() {
        List<House> houses=houseRepository.findAllByDeletedIsFalse();
        List<HouseDTO> houseDTOS=new ArrayList<>();
        for(int i=0;i<houses.size();i++) {
            System.out.println(houses.get(i).getId()+"abc");
            HouseDTO houseDTO=getHouseById(houses.get(i).getId());
            houseDTOS.add(houseDTO);
        }
        return houseDTOS;
    }

    @Override
    public void updateStatusOfHouse(int id) {
        House house = houseRepository.findAllByDeletedIsFalseAndIdIs(id);
        if(house!=null) {
            if(house.getStatus().equals("đã thuê")) {
                house.setStatus("đang thuê");
            } else {
                house.setStatus("đã thuê");
            }
        }
        houseRepository.save(house);
    }
}
