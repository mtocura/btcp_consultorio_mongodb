package br.com.aula3.nosql.consultoriomongodb.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patient")
@Data
@NoArgsConstructor
public class Patient {

  @Id
  private String id;
  private String firstName;
  private String lastName;
  private Integer age;
  private String gender;

  public Patient(String firstName, String lastName, Integer age, String gender) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.gender = gender;
  }
}
