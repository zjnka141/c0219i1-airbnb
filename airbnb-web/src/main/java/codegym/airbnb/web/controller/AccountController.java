package codegym.airbnb.web.controller;

import codegym.airbnb.common.exception.ResourceNotFoundException;
import codegym.airbnb.dao.dto.AccountDTO;
import codegym.airbnb.dao.entity.UpdatePassword;
import codegym.airbnb.services.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("")
    public ResponseEntity<?> createAccounts(@Valid @RequestBody AccountDTO accountDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.OK);
        }
        accountService.save(accountDTO);
        return ResponseEntity.ok(accountDTO);
    }
    @PutMapping("/update-password/{id}")
    public ResponseEntity<?> updatePassword(@PathVariable(value = "id") Integer accountId,
                                            @RequestBody UpdatePassword updatePassword) throws ResourceNotFoundException {
        AccountDTO accountDTO = accountService.findById(accountId);
//        ResponseEntity responseEntity=new
        if (accountDTO != null) {
            if (updatePassword.getCurrentPassword().equals(accountDTO.getPassword())) {
                accountDTO.setPassword(updatePassword.getNewPassword());
                accountService.updatePassword(accountDTO);
                return new ResponseEntity<>("{\"text\":\"Successful\"}",HttpStatus.OK);
            } else {
                return new ResponseEntity<>("{\"text\":\"NotCompare\"}",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("{\"text\":\"NotFound\"}", HttpStatus.OK);
    }
}
