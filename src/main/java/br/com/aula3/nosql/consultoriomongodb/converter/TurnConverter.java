package br.com.aula3.nosql.consultoriomongodb.converter;

import br.com.aula3.nosql.consultoriomongodb.domain.Turn;
import br.com.aula3.nosql.consultoriomongodb.dto.TurnDTO;
import br.com.aula3.nosql.consultoriomongodb.form.TurnForm;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class TurnConverter {
  private static ModelMapper mapper = new ModelMapper();

  public static Turn turnFormToEntity(TurnForm turnForm) {
    return mapper.map(turnForm, Turn.class);
  }

  public static List<Turn> turnFormToEntity(List<TurnForm> turnForms) {
    List<Turn> turns = new ArrayList<>();

    for (TurnForm turnForm : turnForms) {
      turns.add(turnFormToEntity(turnForm));
    }

    return turns;
  }

  public static TurnDTO turnEntityToDTO(Turn turn) {
    return mapper.map(turn, TurnDTO.class);
  }

  public static List<TurnDTO> turnEntityToDTO(List<Turn> turns) {
    List<TurnDTO> turnDTOS = new ArrayList<>();

    for (Turn turn : turns) {
      turnDTOS.add(turnEntityToDTO(turn));
    }

    return turnDTOS;
  }
}
