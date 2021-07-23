package br.com.aula3.nosql.consultoriomongodb.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "dentist")
@Data
@NoArgsConstructor
public class Dentist {

  @Id
  private String id;
  private String firstName;
  private String lastName;
  private String speciality;

  public Dentist(String firstName, String lastName, String speciality) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.speciality = speciality;
  }
}
