package de.trauma.backend.characters.lifestyle.service;

import de.trauma.backend.characters.lifestyle.domain.Lifestyle;
import de.trauma.backend.characters.lifestyle.exceptions.LifestyleNotFoundException;
import de.trauma.backend.characters.lifestyle.repository.LifestyleEntity;
import de.trauma.backend.characters.lifestyle.repository.LifestyleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LifestyleService {
    private final LifestyleRepository lifestyleRepository;

    public LifestyleService(LifestyleRepository lifestyleRepository) {
        this.lifestyleRepository = lifestyleRepository;
    }

    public List<Lifestyle> findAllLifestyles() {
        return this.lifestyleRepository.findAll()
                .stream()
                .map(Lifestyle::new)
                .toList();
    }

    public Optional<Lifestyle> findLifestyleById(Long id) {
        return this.lifestyleRepository.findById(id)
                .map(Lifestyle::new);
    }

    public Lifestyle createLifestyle(Lifestyle lifestyle) {
        return new Lifestyle(this.lifestyleRepository.save(new LifestyleEntity(lifestyle)));
    }

    public Lifestyle updateLifestyle(Long id, Lifestyle lifestyle) {
        Optional<Lifestyle> existingLifestyle = this.lifestyleRepository.findById(id)
                .map(Lifestyle::new);

        if (existingLifestyle.isPresent()) {
            Lifestyle updatedLifestyle = existingLifestyle.get();
            updatedLifestyle.setId(lifestyle.getId());
            updatedLifestyle.setName(lifestyle.getName());
            updatedLifestyle.setDescription(lifestyle.getDescription());
            updatedLifestyle.setGold(lifestyle.getGold());
            updatedLifestyle.setBackgrounds(lifestyle.getBackgrounds());

            return new Lifestyle(this.lifestyleRepository.save(new LifestyleEntity(updatedLifestyle)));
        }
        else {
            throw new LifestyleNotFoundException("Lifestyle could not be found with id: " + id);
        }
    }

    public void deleteLifestyle(Long id) {
        this.lifestyleRepository.deleteById(id);
    }
}
