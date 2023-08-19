package de.trauma.backend.worlds.meta.service;

import de.trauma.backend.worlds.meta.domain.Meta;
import de.trauma.backend.worlds.meta.exceptions.MetaNotFoundException;
import de.trauma.backend.worlds.meta.repository.MetaEntity;
import de.trauma.backend.worlds.meta.repository.MetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaService {
    private final MetaRepository metaRepository;

    public MetaService(MetaRepository metaRepository) {
        this.metaRepository = metaRepository;
    }

    public List<Meta> findAllMetas() {
        return this.metaRepository.findAll()
                .stream()
                .map(Meta::new)
                .toList();
    }

    public Optional<Meta> findMetaById(Long id) {
        return this.metaRepository.findById(id)
                .map(Meta::new);
    }

    public Meta createMeta(Meta meta) {
        return new Meta(this.metaRepository.save(new MetaEntity(meta)));
    }

    public Meta updateMeta(Long id, Meta meta) {
        Optional<Meta> existingMeta = this.metaRepository.findById(id)
                .map(Meta::new);

        if (existingMeta.isPresent()) {
            Meta updatedMeta = existingMeta.get();
            updatedMeta.setId(meta.getId());
            updatedMeta.setMotivation(meta.getMotivation());
            updatedMeta.setGoal(meta.getGoal());
            updatedMeta.setHook(meta.getHook());
            updatedMeta.setGenre(meta.getGenre());
            updatedMeta.setFeel(meta.getFeel());
            updatedMeta.setCharacterAgency(meta.getCharacterAgency());
            updatedMeta.setTone(meta.getTone());
            updatedMeta.setReccuringTheme(meta.getReccuringTheme());
            updatedMeta.setFirstFocusPoint(meta.getFirstFocusPoint());
            updatedMeta.setSecondFocusPoint(meta.getSecondFocusPoint());
            updatedMeta.setThirdFocusPoint(meta.getThirdFocusPoint());
            updatedMeta.setExpandedFocusPoint(meta.getExpandedFocusPoint());
            updatedMeta.setInitialSize(meta.getInitialSize());
            updatedMeta.setNaturalLaws(meta.getNaturalLaws());
            updatedMeta.setCosmology(meta.getCosmology());
            updatedMeta.setGeography(meta.getGeography());
            updatedMeta.setAncientPeople(meta.getAncientPeople());
            updatedMeta.setSpecies(meta.getSpecies());
            updatedMeta.setNeeds(meta.getNeeds());
            updatedMeta.setDramaPoint1(meta.getDramaPoint1());
            updatedMeta.setDramaPoint2(meta.getDramaPoint2());
            updatedMeta.setDramaPoint3(meta.getDramaPoint3());
            updatedMeta.setDramaPoint4(meta.getDramaPoint4());
            updatedMeta.setDramaPoint5(meta.getDramaPoint5());
            updatedMeta.setExpandedDramaPoint(meta.getExpandedDramaPoint());
            updatedMeta.setImagery(meta.getImagery());
            updatedMeta.setMusic(meta.getMusic());
            updatedMeta.setBooks(meta.getBooks());
            updatedMeta.setGaming(meta.getGaming());
            updatedMeta.setWorld(meta.getWorld());

            return new Meta(this.metaRepository.save(new MetaEntity(updatedMeta)));
        }
        else {
            throw new MetaNotFoundException("Meta could not be found with id: " + id);
        }
    }

    public void deleteMeta(Long id) {
        this.metaRepository.deleteById(id);
    }
}
