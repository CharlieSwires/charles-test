package com.phoebussoftware.technicalTest.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {
  Long accountId;
  CustomerDTO customerDTO;
  @NotNull
  @NotEmpty
  Integer accountNumber;
}
