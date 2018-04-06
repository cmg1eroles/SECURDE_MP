package ph.edu.dlsu.securde.SECURDE_MP.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ph.edu.dlsu.securde.SECURDE_MP.model.AnimalDetails;
import ph.edu.dlsu.securde.SECURDE_MP.model.Breed;
import ph.edu.dlsu.securde.SECURDE_MP.repository.AdoptionRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.AnimalDetailsRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.AnimalTypeRepository;
import ph.edu.dlsu.securde.SECURDE_MP.repository.BreedRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    private AnimalDetailsRepository animalDetailsRepository;
    @Autowired
    private BreedRepository breedRepository;
    @Autowired
    private AnimalTypeRepository animalTypeRepository;

    @GetMapping("/posts/adoptions")
    public List<AnimalDetails> getAllPostAdoptions() {
        return animalDetailsRepository.findAll();
    }
    @GetMapping("/posts/breeds")
    public List<Breed> getAllBreeds() {
        return breedRepository.findAll();
    }
}