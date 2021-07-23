package br.com.aula3.nosql.consultoriomongodb.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DentistForm {
  private String firstName;
  private String lastName;
  private String speciality;
}
