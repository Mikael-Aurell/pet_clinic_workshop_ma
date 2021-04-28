package se.lexicon.pet_clinic.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.pet_clinic.dto.PetTypeDto;
import se.lexicon.pet_clinic.entity.Pet;
import se.lexicon.pet_clinic.entity.PetType;
import se.lexicon.pet_clinic.exception.DataNotFoundException;
import se.lexicon.pet_clinic.repository.PetTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public PetTypeDto findById(int id) throws DataNotFoundException {
        if(id < 1) throw new IllegalArgumentException("The id is not valid");

        return modelMapper.map(petTypeRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("PetTypeDto not found")),PetTypeDto.class);

    }

    @Override
    public PetTypeDto save(PetTypeDto dto) {
        if(dto == null) throw new IllegalArgumentException("PetTypeDto not found ");
        if(dto.getId() != 0) throw new IllegalArgumentException("The id should be zero");

        return modelMapper.map(petTypeRepository.save(modelMapper.map(dto, PetType.class)),PetTypeDto.class);

    }

    @Override
    public PetTypeDto update(PetTypeDto dto) throws DataNotFoundException {
        if(dto == null) throw new IllegalArgumentException("PetTypeDto not found ");
        if(dto.getId() < 1) throw new IllegalArgumentException("The id is not valid");

        Optional<PetType> petTypeDtoOptional = petTypeRepository.findById(modelMapper.map(dto,PetType.class).getId());

        if(petTypeDtoOptional.isPresent())
        return modelMapper.map(petTypeRepository.save(modelMapper.map(dto, PetType.class)),PetTypeDto.class);
        else throw new DataNotFoundException("PetTypeDto not found.");
    }

    @Override
    public void delete(int id) {
    if (id < 1) throw new IllegalArgumentException("The id is not valid");
        try {
            petTypeRepository.delete(modelMapper.map(petTypeRepository.findById(id).orElseThrow(()->new DataNotFoundException("Id not found.")), PetType.class));
        } catch (DataNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PetTypeDto> findAll() {
        List<PetType> petTypeList = new ArrayList<>();
        petTypeRepository.findAll().iterator().forEachRemaining(petTypeList::add);
        return petTypeList.stream().map(petType -> modelMapper.map(petType,PetTypeDto.class)).collect(Collectors.toList());
    }

}
