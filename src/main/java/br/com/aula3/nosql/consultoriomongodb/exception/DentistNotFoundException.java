package br.com.aula3.nosql.consultoriomongodb.exception;

public class DentistNotFoundException extends RuntimeException{
  public static String DEFAULT_MESSAGE = "Dentista não encontrado.";

  public DentistNotFoundException() {
    super(DEFAULT_MESSAGE);
  }

  public DentistNotFoundException(String message) {
    super(message);
  }
}
