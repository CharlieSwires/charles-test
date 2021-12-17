package com.phoebussoftware.technicalTest.repository;

import com.phoebussoftware.technicalTest.model.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {}
