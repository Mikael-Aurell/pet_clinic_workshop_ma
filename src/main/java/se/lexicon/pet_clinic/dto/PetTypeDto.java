package se.lexicon.pet_clinic.dto;

import javax.persistence.Column;

public class PetTypeDto {
    private int id;
    @Column(nullable = false, unique = true)
    private String name;

}
