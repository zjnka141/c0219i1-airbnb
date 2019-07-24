package codegym.airbnb.web.controller;

import codegym.airbnb.dao.dto.CustomerDTO;
import codegym.airbnb.dao.entity.Customer;
import codegym.airbnb.services.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")

public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("")
    public List<Customer> getAllCustomers(){
        List<Customer> customers = customerService.findAllByDeletedIsFalse();
        return customers;
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(value = "id") Integer customerId)
    {
        CustomerDTO customerDTO = customerService.findById(customerId);

        return ResponseEntity.ok().body(customerDTO);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Integer customerId) {
        CustomerDTO customer = customerService.findById(customerId);
        customerService.delete(customer.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
