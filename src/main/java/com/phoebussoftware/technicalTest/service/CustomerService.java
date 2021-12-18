package com.phoebussoftware.technicalTest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.DTO.CustomerDTO;
import com.phoebussoftware.technicalTest.model.AccountEntity;
import com.phoebussoftware.technicalTest.model.CustomerEntity;
import com.phoebussoftware.technicalTest.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepository customerRepository;
    @Autowired
    private AccountService accountService;

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

    @Transactional
    public CustomerDTO saveCustomer(CustomerDTO body) {
        List<AccountEntity> aes = new ArrayList<AccountEntity>();
        for (AccountDTO item: body.getAccountDTOS()) {
            accountService.saveAccount(item);
            aes.add(accountService.toEntity(item));
        }
        CustomerEntity entity = CustomerEntity.builder()
                .customerId(body.getCustomerId())
                .forename(body.getForename())
                .surname(body.getSurname())
                .dateOfBirth(body.getDateOfBirth())
                .accountEntities(aes)
                .build();
        customerRepository.save(entity);

        List<AccountDTO> adtol = new ArrayList<AccountDTO>();
        for (AccountEntity item: aes) {
            adtol.add(accountService.toDTO(item));
        }

        return CustomerDTO.builder()
                .customerId(entity.getCustomerId())
                .forename(entity.getForename())
                .surname(entity.getSurname())
                .dateOfBirth(entity.getDateOfBirth())
                .accountDTOS(adtol)
                .build();

    }
}
