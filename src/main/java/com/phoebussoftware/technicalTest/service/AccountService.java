package com.phoebussoftware.technicalTest.service;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.model.AccountEntity;
import com.phoebussoftware.technicalTest.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    public AccountRepository accountRepository;

    public AccountDTO getAccountForId(Integer accountId) {

        Optional<AccountEntity> accountEntity = accountRepository.findById(accountId);
        if (!accountEntity.isPresent()) {
            throw new RuntimeException("Error - not entity found for AccountID = " + accountId);
        }

        return AccountDTO.builder()
                .accountId(accountEntity.get().getAccountId())
                .accountNumber(accountEntity.get().getAccountNumber())
                .build();
    }

    public AccountDTO saveAccount(AccountDTO accountDto) {
        AccountEntity entity = toEntity(accountDto);
        accountRepository.save(entity);
        return accountDto;
    }

    public AccountEntity toEntity(AccountDTO item) {
        return AccountEntity.builder()
                .accountId(item.getAccountId())
                .accountNumber(item.getAccountNumber())
                .build();
    }

    public AccountDTO toDTO(AccountEntity item) {
        return AccountDTO.builder()
        .accountId(item.getAccountId())
        .accountNumber(item.getAccountNumber())
        .build();
    }
}
