package codegym.airbnb.dao.repository;

import codegym.airbnb.dao.entity.BookedHouse;
import codegym.airbnb.dao.entity.House;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedHouseRepository extends JpaRepository<BookedHouse, Integer> {

}
