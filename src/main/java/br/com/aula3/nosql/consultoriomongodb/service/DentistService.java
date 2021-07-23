package br.com.aula3.nosql.consultoriomongodb.service;

import br.com.aula3.nosql.consultoriomongodb.domain.Dentist;
import br.com.aula3.nosql.consultoriomongodb.domain.Patient;
import br.com.aula3.nosql.consultoriomongodb.exception.DentistNotFoundException;
import br.com.aula3.nosql.consultoriomongodb.repository.DentistRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class DentistService {

  private DentistRepository dentistRepository;

  @Autowired
  public DentistService(DentistRepository dentistRepository) {
    this.dentistRepository = dentistRepository;
  }

  public List<Dentist> findAll() {
    return this.dentistRepository.findAll();
  }

  public Dentist findByLastName(String lastName) {
    Optional<Dentist> dentist = this.dentistRepository.findDentistByLastName(lastName);

    if(dentist.isPresent()) {
      return dentist.get();
    }

    throw new DentistNotFoundException();
  }

  public void save(Dentist dentist) {
    this.dentistRepository.save(dentist);
  }

  public void update(Dentist dentist, String lastName) {
    Dentist dentistToUpdate = findByLastName(lastName);

    dentistToUpdate.setFirstName(dentist.getFirstName());
    dentistToUpdate.setLastName(dentist.getLastName());
    dentistToUpdate.setSpeciality(dentist.getSpeciality());

    this.dentistRepository.save(dentistToUpdate);
  }

  public void delete(Dentist dentist) {
    this.dentistRepository.delete(dentist);
  }
}
