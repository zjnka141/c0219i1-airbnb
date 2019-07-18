package codegym.airbnb.dao.repository;



import codegym.airbnb.dao.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepository extends JpaRepository<House,Integer> {
    List<House> findAllByDeletedIsFalse();

    House findAllByDeletedIsFalseAndIdIs(int id);

}
