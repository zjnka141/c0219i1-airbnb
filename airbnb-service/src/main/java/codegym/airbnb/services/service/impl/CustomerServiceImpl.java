package codegym.airbnb.services.service.impl;


import codegym.airbnb.dao.dto.CustomerDTO;
import codegym.airbnb.dao.entity.Customer;
import codegym.airbnb.dao.repository.CustomerRepository;
import codegym.airbnb.services.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import static java.lang.Boolean.TRUE;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllByDeletedIsFalse() {
        return customerRepository.findAllByDeletedIsFalse();
    }

    @Override
    public CustomerDTO findById(Integer id) {
        Customer customer = customerRepository.findById(id).orElse(null);

        if (customer != null) {
//            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(AppConsts.STRING_TO_DATE_FORMAT);
//            String hire_date = customer.getHire_date().format(dateTimeFormatter);

//            Date hire_date= new SimpleDateFormat(AppConsts.STRING_TO_DATE_FORMAT).parse();


            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customer.getId());
//            customerDTO.setHire_date(hire_date);
            customerDTO.setHouse_address(customer.getHouse_address());
            customerDTO.setHouse_type(customer.getHouse_type());
            customerDTO.setTenant(customer.getTenant());
            customerDTO.setPrice(customer.getPrice());

            return customerDTO;
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        customer.setDeleted(TRUE);
        customerRepository.save(customer);
    }
}
