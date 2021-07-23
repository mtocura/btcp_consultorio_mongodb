package br.com.aula3.nosql.consultoriomongodb.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collation = "consulta")
@Data
@NoArgsConstructor
public class Turn {

  @Id
  private String id;

  @Field("patient")
  private Patient patient;

  @Field("doctor")
  private Dentist dentist;

  private String date;

  private String status;

  public Turn(Patient patient, Dentist dentist, String date, String status) {
    this.patient = patient;
    this.dentist = dentist;
    this.date = date;
    this.status = status;
  }
}