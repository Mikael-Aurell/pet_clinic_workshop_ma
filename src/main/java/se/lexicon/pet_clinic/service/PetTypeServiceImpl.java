package se.lexicon.pet_clinic.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.pet_clinic.dto.PetTypeDto;
import se.lexicon.pet_clinic.repository.PetTypeRepository;

import java.util.List;

@Service
public class PetTypeServiceImpl implements PetTypeService{

    PetTypeRepository petTypeRepository;
    ModelMapper modelMapper;

    @Autowired
    public void setPetTypeRepository(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PetTypeDto save(PetTypeDto dto) {
        return null;
    }

    @Override
    public PetTypeDto update(PetTypeDto dto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<PetTypeDto> findAll() {
        return null;
    }

    @Override
    public PetTypeDto findById(int id) {
        return null;
    }
}
