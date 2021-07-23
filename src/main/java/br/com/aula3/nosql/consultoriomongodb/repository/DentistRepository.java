package br.com.aula3.nosql.consultoriomongodb.repository;

import br.com.aula3.nosql.consultoriomongodb.domain.Dentist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DentistRepository extends MongoRepository<Dentist, String> {

  Optional<Dentist> findDentistByLastName(String lastName);
}
