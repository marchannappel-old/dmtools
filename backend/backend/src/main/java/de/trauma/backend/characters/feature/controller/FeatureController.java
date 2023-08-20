package de.trauma.backend.characters.feature.controller;

import de.trauma.backend.characters.feature.domain.Feature;
import de.trauma.backend.characters.feature.service.FeatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/features")
public class FeatureController {
    private final FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @GetMapping
    public List<FeatureDTO> list() {
        return this.featureService.findAllFeatures()
                .stream()
                .map(FeatureDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public FeatureDTO read(@PathVariable Long id) {
        return this.featureService.findFeatureById(id)
                .map(FeatureDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public FeatureDTO create(@RequestBody Feature feature) {
        return new FeatureDTO(this.featureService.createFeature(feature));
    }

    @PutMapping("/{id}")
    public FeatureDTO update(@PathVariable Long id, @RequestBody Feature feature) {
        return new FeatureDTO(this.featureService.updateFeature(id, feature));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.featureService.deleteFeature(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
