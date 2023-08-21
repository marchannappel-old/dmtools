package de.trauma.backend.characters.alignment.controller;

import de.trauma.backend.characters.alignment.domain.Alignment;
import de.trauma.backend.characters.alignment.service.AlignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alignments")
public class AlignmentController {
    private final AlignmentService alignmentService;

    public AlignmentController(AlignmentService alignmentService) {
        this.alignmentService = alignmentService;
    }

    @GetMapping
    public List<AlignmentDTO> list() {
        return this.alignmentService.findAllAlignments()
                .stream()
                .map(AlignmentDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public AlignmentDTO read(@PathVariable Long id) {
        return this.alignmentService.findAlignmentById(id)
                .map(AlignmentDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public AlignmentDTO create(@RequestBody Alignment alignment) {
        return new AlignmentDTO(this.alignmentService.createAlignment(alignment));
    }

    @PutMapping("/{id}")
    public AlignmentDTO update(@PathVariable Long id, @RequestBody Alignment alignment) {
        return new AlignmentDTO(this.alignmentService.updateAlignment(id, alignment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.alignmentService.deleteAlignment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
