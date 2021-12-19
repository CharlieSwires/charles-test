package com.phoebussoftware.technicalTest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.model.AccountEntity;
import com.phoebussoftware.technicalTest.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    public AccountRepository accountRepository;
    @Autowired
    public CustomerService customerService;

    public AccountDTO getAccountForId(Integer accountId) {

        Optional<AccountEntity> accountEntity = accountRepository.findById(accountId);
        if (!accountEntity.isPresent()) {
            throw new RuntimeException("Error - not entity found for AccountID = " + accountId);
        }

        return AccountDTO.builder()
                .accountId(accountEntity.get().getAccountId())
                .accountNumber(accountEntity.get().getAccountNumber())
                .customerDTO(customerService.getCustomerForId (accountEntity.get().getCustomerId()))
               .build();
    }

    public AccountDTO saveAccount(AccountDTO accountDto) {
        AccountEntity entity = toEntity(accountDto);
        accountRepository.save(entity);
        AccountDTO result = toDTO(entity);
        return result;
    }

    public AccountEntity toEntity(AccountDTO item) {
        return AccountEntity.builder()
                .accountId(item.getAccountId())
                .accountNumber(item.getAccountNumber())
                .customerId(item.getCustomerDTO().getCustomerId())
                .build();
    }

    public AccountDTO toDTO(AccountEntity item) {
        return AccountDTO.builder()
        .accountId(item.getAccountId())
        .accountNumber(item.getAccountNumber())
        .customerDTO(customerService.getCustomerForId (item.getCustomerId()))
        .build();
    }
}
