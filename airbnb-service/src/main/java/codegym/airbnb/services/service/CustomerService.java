package codegym.airbnb.services.service;


import codegym.airbnb.dao.dto.CustomerDTO;
import codegym.airbnb.dao.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllByDeletedIsFalse();
    void delete(Integer id) ;
    CustomerDTO findById(Integer id);


}
