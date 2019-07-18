package codegym.airbnb.web.controller;

import codegym.airbnb.common.exception.ResourceNotFoundException;
import codegym.airbnb.dao.dto.AccountDTO;
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
@RequestMapping("")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<?> createAccounts(@Valid @RequestBody AccountDTO accountDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.OK);
        }
        accountService.save(accountDTO);
        return ResponseEntity.ok(accountDTO);
    }
    @PutMapping("/accounts/update-password/{id}")
    public ResponseEntity<AccountDTO> updatePassword(@PathVariable(value = "id") Integer accountId,
                                                     @Valid @RequestBody AccountDTO accountDetails) throws ResourceNotFoundException {
        AccountDTO accountDTO = accountService.findById(accountId);
        accountDTO.setPassword(accountDetails.getPassword());
        final AccountDTO updatedAccount = accountService.updatePassword(accountDTO);
        return ResponseEntity.ok(updatedAccount);
    }
}
