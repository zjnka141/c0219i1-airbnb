package codegym.airbnb.services.service;

import codegym.airbnb.dao.dto.FeedbackDTO;
import codegym.airbnb.dao.entity.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FeedbackService {
    void create(FeedbackDTO feedbackDTO, Integer houseId);

    void update(FeedbackDTO feedbackDTO);

    FeedbackDTO findById(Integer id);

    void delete(Integer id);
    List<Feedback> findAllByDeletedIsFalse();

    List<Feedback> findAllByHouseId(Integer hosueId);
}
