package de.trauma.backend.characters.race.service;

import de.trauma.backend.characters.race.domain.Race;
import de.trauma.backend.characters.race.exceptions.RaceNotFoundException;
import de.trauma.backend.characters.race.repository.RaceEntity;
import de.trauma.backend.characters.race.repository.RaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceService {
    private final RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<Race> findAllRaces() {
        return this.raceRepository.findAll()
                .stream()
                .map(Race::new)
                .toList();
    }

    public Optional<Race> findRaceById(Long id) {
        return this.raceRepository.findById(id)
                .map(Race::new);
    }

    public Race createRace(Race race) {
        return new Race(this.raceRepository.save(new RaceEntity(race)));
    }

    public Race updateRace(Long id, Race race) {
        Optional<Race> existingRace = this.raceRepository.findById(id)
                .map(Race::new);

        if (existingRace.isPresent()) {
            Race updatedRace = existingRace.get();
            updatedRace.setId(race.getId());
            updatedRace.setName(race.getName());
            updatedRace.setPronunciation(race.getPronunciation());
            updatedRace.setSubTitle(race.getSubTitle());
            updatedRace.setDescription(race.getDescription());
            updatedRace.setRacialTraits(race.getRacialTraits());
            updatedRace.setAppearance(race.getAppearance());
            updatedRace.setHabitat(race.getHabitat());
            updatedRace.setPeculiarities(race.getPeculiarities());
            updatedRace.setClans(race.getClans());
            updatedRace.setNames(race.getNames());
            updatedRace.setMainRace(race.getMainRace());
            updatedRace.setSubraces(race.getSubraces());
            updatedRace.setDefenses(race.getDefenses());
            updatedRace.setCharacters(race.getCharacters());
            updatedRace.setNpcs(race.getNpcs());

            return new Race(this.raceRepository.save(new RaceEntity(updatedRace)));
        }
        else {
            throw new RaceNotFoundException("Race could not be found with id: " + id);
        }
    }

    public void deleteRace(Long id) {
        this.raceRepository.deleteById(id);
    }
}
