package de.trauma.backend.characters.feature.service;

import de.trauma.backend.characters.feature.domain.Feature;
import de.trauma.backend.characters.feature.exceptions.FeatureNotFoundException;
import de.trauma.backend.characters.feature.repository.FeatureEntity;
import de.trauma.backend.characters.feature.repository.FeatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeatureService {
    private final FeatureRepository featureRepository;

    public FeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    public List<Feature> findAllFeatures() {
        return this.featureRepository.findAll()
                .stream()
                .map(Feature::new)
                .toList();
    }

    public Optional<Feature> findFeatureById(Long id) {
        return this.featureRepository.findById(id).map(Feature::new);
    }

    public Feature createFeature(Feature feature) {
        return new Feature(this.featureRepository.save(new FeatureEntity(feature)));
    }

    public Feature updateFeature(Long id, Feature feature) {
        Optional<Feature> existingFeature = this.featureRepository.findById(id)
                .map(Feature::new);

        if (existingFeature.isPresent()) {
            Feature updatedFeature = existingFeature.get();
            updatedFeature.setId(feature.getId());
            updatedFeature.setName(feature.getName());
            updatedFeature.setLevel(feature.getLevel());
            updatedFeature.setDescription(feature.getDescription());
            updatedFeature.setClasses(feature.getClasses());
            updatedFeature.setMonsters(feature.getMonsters());
            updatedFeature.setBackgrounds(feature.getBackgrounds());

            return new Feature(this.featureRepository.save(new FeatureEntity(updatedFeature)));
        }
        else {
            throw new FeatureNotFoundException("Feature could not be found with id: " + id);
        }
    }

    public void deleteFeature(Long id) {
        this.featureRepository.deleteById(id);
    }
}
