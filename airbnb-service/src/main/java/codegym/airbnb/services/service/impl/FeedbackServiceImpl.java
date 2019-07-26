package codegym.airbnb.services.service.impl;

import codegym.airbnb.dao.dto.FeedbackDTO;
import codegym.airbnb.dao.entity.Feedback;
import codegym.airbnb.dao.entity.House;
import codegym.airbnb.dao.repository.FeedbackRepository;
import codegym.airbnb.dao.repository.HouseRepository;
import codegym.airbnb.services.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    HouseRepository houseRepository;


    @Override
    public void create(FeedbackDTO feedbackDTO, Integer houseId) {
        Feedback feedback = new Feedback();
        feedback.setId(feedbackDTO.getId());
        feedback.setDescribe(feedbackDTO.getDescribe());
        feedback.setRating(feedbackDTO.getRating());
        feedback.setDeleted(Boolean.FALSE);
        feedback.setName(feedbackDTO.getName());
        feedback.setEmail(feedbackDTO.getEmail());
        feedback.setHouse(houseRepository.findById(houseId).orElse(null));

        feedbackRepository.save(feedback);
    }

    @Override
    public void update(FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackRepository.findById(feedbackDTO.getId()).orElse(null);
        feedback.setId(feedbackDTO.getId());
        feedback.setDescribe(feedbackDTO.getDescribe());
        feedback.setRating(feedbackDTO.getRating());
        feedback.setName(feedbackDTO.getName());
        feedback.setEmail(feedbackDTO.getEmail());
        feedbackRepository.save(feedback);
    }

    @Override
    public FeedbackDTO findById(Integer id) {
        Feedback feedback = feedbackRepository.findById(id).orElse(null);
        if (feedback != null) {
            FeedbackDTO feedbackDTO = new FeedbackDTO();
            feedbackDTO.setId(feedback.getId());
            feedbackDTO.setDescribe(feedback.getDescribe());
            feedbackDTO.setRating(feedback.getRating());
            feedbackDTO.setHouse(feedback.getHouse());
            feedbackDTO.setName(feedback.getName());
            feedbackDTO.setEmail(feedback.getEmail());
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Feedback feedback = feedbackRepository.findById(id).orElse(null);
        if (feedback != null) {
            feedbackRepository.delete(feedback);
        }
    }

    @Override
    public List<Feedback> findAllByHouseId(Integer houseId) {
        House house = houseRepository.findById(houseId).orElse(null);
        List<Feedback> feedbacks = feedbackRepository.findAllByHouse(house);
        return feedbacks;
    }

    @Override
    public List<Feedback> findAllByDeletedIsFalse() {
        return feedbackRepository.findAllByDeletedIsFalse();
    }
}
