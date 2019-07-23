package codegym.airbnb.dao.repository;



import codegym.airbnb.dao.entity.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepository extends JpaRepository<House,Integer> {
    List<House> findAllByDeletedIsFalse();
    Page<House> findAllByDeletedIsFalse(Pageable pageable);
    House findAllByDeletedIsFalseAndIdIs(int id);

}
