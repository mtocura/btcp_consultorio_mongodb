package br.com.aula3.nosql.consultoriomongodb.exception.handler;

import br.com.aula3.nosql.consultoriomongodb.dto.ExceptionDTO;
import br.com.aula3.nosql.consultoriomongodb.exception.DentistNotFoundException;
import br.com.aula3.nosql.consultoriomongodb.exception.PatientNotFoundException;
import br.com.aula3.nosql.consultoriomongodb.exception.TurnNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClinicExceptionHandler {

  @ExceptionHandler(PatientNotFoundException.class)
  public ResponseEntity<ExceptionDTO> patientNotFoundHandler(PatientNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(e.getMessage()));
  }

  @ExceptionHandler(DentistNotFoundException.class)
  public ResponseEntity<ExceptionDTO> dentistNotFoundHandler(DentistNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(e.getMessage()));
  }

  @ExceptionHandler(TurnNotFoundException.class)
  public ResponseEntity<ExceptionDTO> turnNotFoundHandler(TurnNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(e.getMessage()));
  }
}
