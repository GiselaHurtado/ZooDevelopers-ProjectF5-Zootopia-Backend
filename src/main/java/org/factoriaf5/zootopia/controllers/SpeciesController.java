package org.factoriaf5.zootopia.controllers;


import java.util.List;

import org.factoriaf5.zootopia.models.Species;
import org.factoriaf5.zootopia.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/species")
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class SpeciesController {

    @Autowired
    private SpeciesService speciesService;

    @GetMapping
public List<Species> getAllSpecies() {
    return speciesService.getAllSpecies(Pageable.unpaged()).getContent();
}


    @PostMapping
    public Species createSpecies(@RequestBody Species species) {
        return speciesService.saveSpecies(species);
    }

    @PutMapping("/{id}")
    public Species updateSpecies(@PathVariable Long id, @RequestBody Species species) {
        return speciesService.updateSpecies(id, species);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecies(@PathVariable Long id) {
        speciesService.deleteSpecies(id);
    }

    @GetMapping("/filter")
    public List<Species> filterSpecies(@RequestParam(required = false) String family,
                                       @RequestParam(required = false) String type) {
        if (family != null) {
            return speciesService.filterByFamily(family);
        } else if (type != null) {
            return speciesService.filterByType(type);
        } else {
            return speciesService.getAllSpecies(Pageable.unpaged()).getContent();
        }
    }
}