package com.phoebussoftware.technicalTest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {
  @Id Long customerId;

  @OneToMany List<AccountEntity> accountEntities;

  @NotNull
  String forename;

  @NotNull
  String surname;

  @NotNull
  Date dateOfBirth;
}
