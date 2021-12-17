package com.phoebussoftware.technicalTest.web;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.DTO.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Integer customerId) {
    return ResponseEntity.ok(CustomerDTO.builder().build());
  }

  @GetMapping("/account/{customerId}")
  public ResponseEntity<List<AccountDTO>> getAccountsByCustomerId(
      @PathVariable Integer customerId) {
    List<AccountDTO> accountDTOS = List.of(AccountDTO.builder().build());
    return new ResponseEntity<>(accountDTOS, HttpStatus.OK);
  }
}
