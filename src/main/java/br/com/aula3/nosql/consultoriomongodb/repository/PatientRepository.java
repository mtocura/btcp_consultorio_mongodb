package br.com.aula3.nosql.consultoriomongodb.repository;

import br.com.aula3.nosql.consultoriomongodb.domain.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

  Optional<Patient> findPatientByLastName(String lastName);
}
