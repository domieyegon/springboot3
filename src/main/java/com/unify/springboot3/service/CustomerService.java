package com.unify.springboot3.service;

import com.unify.springboot3.controller.request.CustomerRequest;
import com.unify.springboot3.domain.Customer;
import com.unify.springboot3.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public void addCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setName(customerRequest.name());
        customer.setEmail(customerRequest.email());
        customer.setAge(customerRequest.age());

        customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    public void updateCustomer(Integer id, CustomerRequest customerRequest) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.setName(customerRequest.name());
            customer.setEmail(customerRequest.email());
            customer.setAge(customerRequest.age());

            customerRepository.save(customer);
        }
    }
}
