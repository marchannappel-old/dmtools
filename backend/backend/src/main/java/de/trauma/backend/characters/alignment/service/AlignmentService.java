package de.trauma.backend.characters.alignment.service;

import de.trauma.backend.characters.alignment.domain.Alignment;
import de.trauma.backend.characters.alignment.exceptions.AlignmentNotFoundException;
import de.trauma.backend.characters.alignment.repository.AlignmentEntity;
import de.trauma.backend.characters.alignment.repository.AlignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlignmentService {
    private final AlignmentRepository alignmentRepository;

    public AlignmentService(AlignmentRepository alignmentRepository) {
        this.alignmentRepository = alignmentRepository;
    }

    public List<Alignment> findAllAlignments() {
        return this.alignmentRepository.findAll()
                .stream()
                .map(Alignment::new)
                .toList();
    }

    public Optional<Alignment> findAlignmentById(Long id) {
        return this.alignmentRepository.findById(id)
                .map(Alignment::new);
    }

    public Alignment createAlignment(Alignment alignment) {
        return new Alignment(this.alignmentRepository.save(new AlignmentEntity(alignment)));
    }

    public Alignment updateAlignment(Long id, Alignment alignment) {
        Optional<Alignment> existingAlignment = this.alignmentRepository.findById(id)
                .map(Alignment::new);

        if (existingAlignment.isPresent()) {
            Alignment updatedAlignment = existingAlignment.get();
            updatedAlignment.setId(alignment.getId());
            updatedAlignment.setName(alignment.getName());
            updatedAlignment.setDescription(alignment.getDescription());
            updatedAlignment.setBackgrounds(alignment.getBackgrounds());
            updatedAlignment.setMonsters(alignment.getMonsters());

            return new Alignment(this.alignmentRepository.save(new AlignmentEntity(updatedAlignment)));
        }
        else {
            throw new AlignmentNotFoundException("Alignment could not be found with id: " + id);
        }
    }

    public void deleteAlignment(Long id) {
        this.alignmentRepository.deleteById(id);
    }
}
