package br.com.aula3.nosql.consultoriomongodb.repository;

import br.com.aula3.nosql.consultoriomongodb.domain.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
}
