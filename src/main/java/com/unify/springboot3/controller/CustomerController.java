package com.unify.springboot3.controller;

import com.unify.springboot3.controller.request.CustomerRequest;
import com.unify.springboot3.domain.Customer;
import com.unify.springboot3.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping
    public void addCustomer(@RequestBody CustomerRequest customerRequest){
        customerService.addCustomer(customerRequest);
    }

    @PutMapping("/{customerId}")
    public void updateCustomer(@PathVariable(name = "customerId")Integer id, @RequestBody CustomerRequest customerRequest){
        customerService.updateCustomer(id,customerRequest);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable(name = "customerId") Integer id){
        customerService.deleteCustomer(id);
    }
}
