package se.lexicon.pet_clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.pet_clinic.dto.PetTypeDto;
import se.lexicon.pet_clinic.entity.PetType;
import se.lexicon.pet_clinic.exception.DataNotFoundException;
import se.lexicon.pet_clinic.service.PetTypeService;

import java.util.List;

@RestController
@RequestMapping("api/ver1/pettype")
public class PetTypeController {

    PetTypeService petTypeService;

    @Autowired
    public void setPetTypeService(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PetTypeDto>> findAll(){
        return ResponseEntity.ok(petTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetTypeDto> findById(@PathVariable("id")Integer id){
        try {
            return ResponseEntity.ok(petTypeService.findById(id));
        } catch (DataNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<PetTypeDto> save(@RequestBody PetTypeDto dto){
        return ResponseEntity.ok(petTypeService.save(dto));
    }

    @PutMapping("/")
    public ResponseEntity<PetTypeDto> update(@RequestBody PetTypeDto dto){
        try {
            return ResponseEntity.ok(petTypeService.update(dto));
        } catch (DataNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PetTypeDto> delete(@PathVariable("id") Integer id){
        try {
            petTypeService.delete(id);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (DataNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

}
