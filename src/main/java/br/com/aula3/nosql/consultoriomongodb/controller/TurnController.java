package br.com.aula3.nosql.consultoriomongodb.controller;

import br.com.aula3.nosql.consultoriomongodb.converter.TurnConverter;
import br.com.aula3.nosql.consultoriomongodb.domain.Turn;
import br.com.aula3.nosql.consultoriomongodb.dto.TurnDTO;
import br.com.aula3.nosql.consultoriomongodb.form.TurnForm;
import br.com.aula3.nosql.consultoriomongodb.service.TurnService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turns")
@NoArgsConstructor
public class TurnController {

  private TurnService turnService;

  @Autowired
  public TurnController(TurnService turnService) {
    this.turnService = turnService;
  }

  @PostMapping
  public ResponseEntity<TurnDTO> createTurn(@RequestBody TurnForm turnForm) {
    Turn turn = TurnConverter.turnFormToEntity(turnForm);
    TurnDTO turnDTO = TurnConverter.turnEntityToDTO(this.turnService.save(turn));

    return ResponseEntity.ok(turnDTO);
  }

  @GetMapping
  public ResponseEntity<List<TurnDTO>> findAll() {
    List<TurnDTO> turnDTOS = TurnConverter.turnEntityToDTO(this.turnService.findAll());

    return ResponseEntity.ok(turnDTOS);
  }

  @GetMapping("/status/{status}")
  public ResponseEntity<List<TurnDTO>> findByStatus(@PathVariable String status) {
    List<TurnDTO> turnDTOS = TurnConverter.turnEntityToDTO(this.turnService.findByStatus(status));

    return ResponseEntity.ok(turnDTOS);
  }

  @GetMapping("/dentist/{dentistLastName}")
  public ResponseEntity<List<TurnDTO>> findByDentist(@PathVariable String dentistLastName) {
    List<TurnDTO> turnDTOS = TurnConverter.turnEntityToDTO(this.turnService.findByDentistLastName(dentistLastName));

    return ResponseEntity.ok(turnDTOS);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateTurn(@RequestBody Turn turn, @PathVariable String id) {
    this.turnService.update(turn, id);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping()
  public ResponseEntity<?> deleteTurn(@RequestBody Turn turn) {
    this.turnService.delete(turn);
    return ResponseEntity.ok().build();
  }
}
