package se.lexicon.pet_clinic.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class PetTypeDto {
    private int id;
    @Column(nullable = false, unique = true)
    private String name;

}
