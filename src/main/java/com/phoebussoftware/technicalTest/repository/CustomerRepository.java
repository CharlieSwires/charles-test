package com.phoebussoftware.technicalTest.repository;

import com.phoebussoftware.technicalTest.model.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {}
