package com.phoebussoftware.technicalTest.service;

import com.phoebussoftware.technicalTest.DTO.CustomerDTO;
import com.phoebussoftware.technicalTest.model.CustomerEntity;
import com.phoebussoftware.technicalTest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepository customerRepository;

    public CustomerDTO getCustomerForId (Integer customerId) {
        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(customerId);
        if (!customerEntityOptional.isPresent()) {
            throw new RuntimeException("customer not found for identifier " + customerId);
        }
        CustomerEntity customerEntity = customerEntityOptional.get();
        return CustomerDTO.builder()
                .customerId(customerEntity.getCustomerId())
                .forename(customerEntity.getForename())
                .surname(customerEntity.getSurname())
                .dateOfBirth(customerEntity.getDateOfBirth())
                .build();
    }
}
