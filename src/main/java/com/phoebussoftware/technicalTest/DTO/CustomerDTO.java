package com.phoebussoftware.technicalTest.DTO;

import java.util.Date;
import java.util.List;

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
public class CustomerDTO {
  Long customerId;
  List<AccountDTO> accountDTOS;
  @NotNull
  @NotEmpty
  String forename;
  @NotNull
  @NotEmpty
  String surname;
  @NotNull
  @NotEmpty
  Date dateOfBirth;
}
