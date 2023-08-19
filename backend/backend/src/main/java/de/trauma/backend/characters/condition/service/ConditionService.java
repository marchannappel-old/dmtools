package de.trauma.backend.characters.condition.service;

import de.trauma.backend.characters.condition.domain.Condition;
import de.trauma.backend.characters.condition.exceptions.ConditionNotFoundException;
import de.trauma.backend.characters.condition.repository.ConditionEntity;
import de.trauma.backend.characters.condition.repository.ConditionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConditionService {
    private final ConditionRepository conditionRepository;

    public ConditionService(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    public List<Condition> findAllConditions() {
        return this.conditionRepository.findAll()
                .stream()
                .map(Condition::new)
                .toList();
    }

    public Optional<Condition> findConditionById(Long id) {
        return this.conditionRepository.findById(id)
                .map(Condition::new);
    }

    public Condition createCondition(Condition condition) {
        return new Condition(this.conditionRepository.save(new ConditionEntity(condition)));
    }

    public Condition updateCondition(Long id, Condition condition) {
        Optional<Condition> existingCondition = this.conditionRepository.findById(id)
                .map(Condition::new);

        if (existingCondition.isPresent()) {
            Condition updatedCondition = existingCondition.get();
            updatedCondition.setId(condition.getId());
            updatedCondition.setName(condition.getName());
            updatedCondition.setDescription(condition.getDescription());
            updatedCondition.setCharacters(condition.getCharacters());

            return new Condition(this.conditionRepository.save(new ConditionEntity(updatedCondition)));
        }
        else {
            throw new ConditionNotFoundException("Condition could not be found with id: " + id);
        }
    }

    public void deleteCondition(Long id) {
        this.conditionRepository.deleteById(id);
    }
}
