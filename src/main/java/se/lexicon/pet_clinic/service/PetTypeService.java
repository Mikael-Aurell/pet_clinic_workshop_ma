package se.lexicon.pet_clinic.service;

import se.lexicon.pet_clinic.dto.PetTypeDto;
import se.lexicon.pet_clinic.exception.DataNotFoundException;

import java.util.List;

public interface PetTypeService {

    PetTypeDto save(PetTypeDto dto);
    PetTypeDto update(PetTypeDto dto) throws DataNotFoundException;
    void delete(int id) throws DataNotFoundException;
    List<PetTypeDto> findAll();
    PetTypeDto findById(int id) throws DataNotFoundException;
}
