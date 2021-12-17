package com.phoebussoftware.technicalTest.web;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.service.AccountService;
import org.hibernate.type.YesNoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

  @Autowired
  private AccountService accountService;

  @GetMapping("/{accountId}")
  public ResponseEntity<AccountDTO> getAccountById(@PathVariable Integer accountId) {
    AccountDTO account = accountService.getAccountForId(accountId);
    return ResponseEntity.ok(account);
  }

  @PostMapping("/accountDTO")
  public ResponseEntity<AccountDTO> saveAccount(@RequestBody AccountDTO body) {
    accountService.saveAccount(body);
    return new ResponseEntity<>(body, HttpStatus.CREATED);
  }
}
