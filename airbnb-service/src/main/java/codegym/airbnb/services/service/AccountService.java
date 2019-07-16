package codegym.airbnb.services.service;

import codegym.airbnb.dao.dto.AccountDTO;
import codegym.airbnb.dao.entity.Account;

import java.util.List;


public interface AccountService {
    List<Account> findAllByDeletedIsFalse();

    void save(AccountDTO acoountDTO);

    AccountDTO updatePassword(AccountDTO accountDTO);

    AccountDTO findById(Integer id);
}
