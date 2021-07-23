package br.com.aula3.nosql.consultoriomongodb.service;

import br.com.aula3.nosql.consultoriomongodb.domain.Turn;
import br.com.aula3.nosql.consultoriomongodb.exception.TurnNotFoundException;
import br.com.aula3.nosql.consultoriomongodb.repository.TurnRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class TurnService {

  private TurnRepository turnRepository;
  private PatientService patientService;
  private DentistService dentistService;

  @Autowired
  public TurnService(TurnRepository turnRepository, PatientService patientService, DentistService dentistService) {
    this.turnRepository = turnRepository;
    this.patientService = patientService;
    this.dentistService = dentistService;
  }

  public List<Turn> findAll() {
    return this.turnRepository.findAll();
  }

  public List<Turn> findByStatus(String status) {
    return this.turnRepository.findTurnsByStatus(status);
  }

  public List<Turn> findByDentistLastName(String dentistLastName) {
    return this.turnRepository.findTurnsByDentist_LastName(dentistLastName);
  }

  public void save(Turn turn) {
    this.patientService.save(turn.getPatient());
    this.dentistService.save(turn.getDentist());
    this.turnRepository.save(turn);
  }

  public void update(Turn turn, String id) {
    Optional<Turn> turnOptional = this.turnRepository.findById(id);

    if(turnOptional.isEmpty()) {
      throw new TurnNotFoundException();
    }

    Turn turnToUpdate = turnOptional.get();

    this.patientService.update(turn.getPatient(), turn.getPatient().getLastName());
    this.dentistService.update(turn.getDentist(), turn.getDentist().getLastName());
    turnToUpdate.setPatient(turn.getPatient());
    turnToUpdate.setDentist(turn.getDentist());
    turnToUpdate.setDate(turn.getDate());
    turnToUpdate.setStatus(turn.getStatus());

    this.turnRepository.save(turnToUpdate);
  }

  public void delete(Turn turn) {
    this.turnRepository.delete(turn);
  }
}
