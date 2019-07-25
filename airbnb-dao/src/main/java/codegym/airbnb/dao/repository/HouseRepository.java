package codegym.airbnb.dao.repository;



import codegym.airbnb.dao.entity.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseRepository extends JpaRepository<House,Integer> {
    List<House> findAllByDeletedIsFalse();
    Page<House> findAllByDeletedIsFalseAndNameContainingIgnoreCase(Pageable pageable, String name);
    @Query(value = "SELECT * FROM houses WHERE UPPER(name) LIKE CONCAT('%', CONCAT(UPPER(?1), '%')) AND " +
                    "CAST(price_by_night AS UNSIGNED) between ?2 AND ?3 AND number_of_bedrooms IN ?4 AND type_room IN ?5",
            countQuery = "SELECT count(*) FROM houses WHERE UPPER(name) LIKE CONCAT('%', CONCAT(UPPER(?1), '%')) AND " +
                    "CAST(price_by_night AS UNSIGNED) between ?2 AND ?3  AND number_of_bedrooms IN ?4 AND type_room IN ?5",
            nativeQuery = true)
    Page<House> findAll( String name, int min, int max, List<Integer> numBed, List<String> typeBed, Pageable pageable);
    House findAllByDeletedIsFalseAndIdIs(int id);

}
