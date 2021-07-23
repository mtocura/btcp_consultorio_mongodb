package br.com.aula3.nosql.consultoriomongodb.converter;

import br.com.aula3.nosql.consultoriomongodb.domain.Patient;
import br.com.aula3.nosql.consultoriomongodb.dto.PatientDTO;
import br.com.aula3.nosql.consultoriomongodb.form.PatientForm;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class PatientConverter {
  private static ModelMapper mapper = new ModelMapper();

  public static Patient patientFormToEntity(PatientForm patientForm) {
    return mapper.map(patientForm, Patient.class);
  }

  public List<Patient> patientFormToEntity(List<PatientForm> patientForms) {
    List<Patient> patients = new ArrayList<>();

    for (PatientForm patientForm : patientForms) {
      patients.add(patientFormToEntity(patientForm));
    }

    return patients;
  }

  public static PatientDTO patientEntityToDTO(Patient patient) {
    return mapper.map(patient, PatientDTO.class);
  }

  public List<PatientDTO> patientEntityToDTO(List<Patient> patients) {
    List<PatientDTO> patientDTOS = new ArrayList<>();

    for (Patient patient : patients) {
      patientDTOS.add(patientEntityToDTO(patient));
    }

    return patientDTOS;
  }
}
