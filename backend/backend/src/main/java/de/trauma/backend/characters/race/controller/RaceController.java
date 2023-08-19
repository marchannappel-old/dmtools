package de.trauma.backend.characters.race.controller;

import de.trauma.backend.characters.race.domain.Race;
import de.trauma.backend.characters.race.service.RaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/races")
public class RaceController {
    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public List<RaceDTO> list() {
        return this.raceService.findAllRaces()
                .stream()
                .map(RaceDTO::new)
                .toList();
    }

    public RaceDTO read(@PathVariable Long id) {
        return this.raceService.findRaceById(id)
                .map(RaceDTO::new)
                .orElseThrow();
    }

    public RaceDTO create(@RequestBody Race race) {
        return new RaceDTO(this.raceService.createRace(race));
    }

    public RaceDTO update(@PathVariable Long id, @RequestBody Race race) {
        return new RaceDTO(this.raceService.updateRace(id, race));
    }

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.raceService.deleteRace(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
