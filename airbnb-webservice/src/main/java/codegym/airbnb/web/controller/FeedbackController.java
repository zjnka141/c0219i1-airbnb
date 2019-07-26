package codegym.airbnb.web.controller;

import codegym.airbnb.dao.dto.FeedbackDTO;
import codegym.airbnb.dao.dto.HouseDTO;
import codegym.airbnb.dao.entity.Feedback;
import codegym.airbnb.dao.repository.FeedbackRepository;
import codegym.airbnb.dao.repository.HouseRepository;
import codegym.airbnb.services.service.FeedbackService;
import codegym.airbnb.services.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/feedbacks")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @Autowired
    HouseService houseService;

    @Autowired
    FeedbackRepository feedbackRepository;

    @GetMapping("/house/{id}")
    public List<Feedback> getAllFeebackByHouseId (@PathVariable Integer id) {
        return feedbackService.findAllByHouseId(id);
    }

    @GetMapping("")
    public List<Feedback> getAllFeedback() {
        return feedbackService.findAllByDeletedIsFalse();
    }

    @PostMapping("/house/{id}")
    public ResponseEntity<FeedbackDTO> createFeedback(@Valid @RequestBody FeedbackDTO feedbackDTO,
                                      @PathVariable (value = "id") Integer houseId) {
        feedbackService.create(feedbackDTO, houseId);
        return ResponseEntity.ok(feedbackDTO);
    }


}
