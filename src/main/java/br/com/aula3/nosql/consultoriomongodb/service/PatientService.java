package br.com.aula3.nosql.consultoriomongodb.service;

import br.com.aula3.nosql.consultoriomongodb.domain.Patient;
import br.com.aula3.nosql.consultoriomongodb.exception.PatientNotFoundException;
import br.com.aula3.nosql.consultoriomongodb.repository.PatientRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class PatientService {

  private PatientRepository patientRepository;

  @Autowired
  public PatientService(PatientRepository patientRepository) {
    this.patientRepository = patientRepository;
  }

  public List<Patient> findAll() {
    return this.patientRepository.findAll();
  }

  public Patient findByLastName(String lastName) {
    Optional<Patient> patient = this.patientRepository.findPatientByLastName(lastName);

    if(patient.isPresent()) {
      return patient.get();
    }

    throw new PatientNotFoundException();
  }

  public void save(Patient patient) {
    this.patientRepository.save(patient);
  }

  public void update(Patient patient, String lastName) {
    Patient patientToUpdate = findByLastName(lastName);

    patientToUpdate.setFirstName(patient.getFirstName());
    patientToUpdate.setLastName(patient.getLastName());
    patientToUpdate.setAge(patient.getAge());
    patientToUpdate.setGender(patient.getGender());

    this.patientRepository.save(patientToUpdate);
  }

  public void delete(Patient patient) {
    this.patientRepository.delete(patient);
  }
}
