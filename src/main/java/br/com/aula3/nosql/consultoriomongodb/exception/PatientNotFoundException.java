package br.com.aula3.nosql.consultoriomongodb.exception;

public class PatientNotFoundException extends RuntimeException{
  public static String DEFAULT_MESSAGE = "Paciente não encontrado.";

  public PatientNotFoundException() {
    super(DEFAULT_MESSAGE);
  }

  public PatientNotFoundException(String message) {
    super(message);
  }
}
