package br.com.aula3.nosql.consultoriomongodb.exception;

public class TurnNotFoundException extends RuntimeException{
  public static String DEFAULT_MESSAGE = "Consulta não encontrada.";

  public TurnNotFoundException() {
    super(DEFAULT_MESSAGE);
  }

  public TurnNotFoundException(String message) {
    super(message);
  }
}
