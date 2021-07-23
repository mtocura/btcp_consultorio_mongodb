package br.com.aula3.nosql.consultoriomongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnDTO {
  private String id;
  private PatientDTO patient;
  private DentistDTO dentist;
  private String date;
  private String status;
}
