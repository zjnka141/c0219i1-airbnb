package codegym.airbnb.dao.repository;

import codegym.airbnb.dao.entity.Feedback;
import codegym.airbnb.dao.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    List<Feedback> findAllByDeletedIsFalse();
    List<Feedback> findAllByHouse (House house);
}
