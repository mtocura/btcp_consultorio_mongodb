package br.com.aula3.nosql.consultoriomongodb.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnForm {
  private PatientForm patient;
  private DentistForm doctor;
  private String date;
  private String status;
}
