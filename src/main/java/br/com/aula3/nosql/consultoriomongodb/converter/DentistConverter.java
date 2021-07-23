package br.com.aula3.nosql.consultoriomongodb.converter;

import br.com.aula3.nosql.consultoriomongodb.domain.Dentist;
import br.com.aula3.nosql.consultoriomongodb.dto.DentistDTO;
import br.com.aula3.nosql.consultoriomongodb.form.DentistForm;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class DentistConverter {
  private static ModelMapper mapper = new ModelMapper();

  public static Dentist dentistFormToEntity(DentistForm dentistForm) {
    return mapper.map(dentistForm, Dentist.class);
  }

  public List<Dentist> dentistFormToEntity(List<DentistForm> dentistForms) {
    List<Dentist> dentists = new ArrayList<>();

    for (DentistForm dentistForm : dentistForms) {
      dentists.add(dentistFormToEntity(dentistForm));
    }

    return dentists;
  }

  public static DentistDTO dentistEntityToDTO(Dentist dentist) {
    return mapper.map(dentist, DentistDTO.class);
  }

  public List<DentistDTO> dentistEntityToDTO(List<Dentist> dentists) {
    List<DentistDTO> dentistDTOS = new ArrayList<>();

    for (Dentist dentist : dentists) {
      dentistDTOS.add(dentistEntityToDTO(dentist));
    }

    return dentistDTOS;
  }
}
