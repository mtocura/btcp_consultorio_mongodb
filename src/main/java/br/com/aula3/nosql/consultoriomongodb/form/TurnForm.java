package br.com.aula3.nosql.consultoriomongodb.form;

import br.com.aula3.nosql.consultoriomongodb.domain.Dentist;
import br.com.aula3.nosql.consultoriomongodb.domain.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnForm {
  @Field("patient")
  private PatientForm patient;

  @Field("doctor")
  private DentistForm dentist;

  private String date;

  private String status;
}
