package de.trauma.backend.campaignCreation.monsterCreation.action.service;

import de.trauma.backend.campaignCreation.monsterCreation.action.domain.Action;
import de.trauma.backend.campaignCreation.monsterCreation.action.exceptions.ActionNotFoundException;
import de.trauma.backend.campaignCreation.monsterCreation.action.repository.ActionEntity;
import de.trauma.backend.campaignCreation.monsterCreation.action.repository.ActionRepository;
import de.trauma.backend.campaignCreation.monsterCreation.monster.domain.Monster;
import de.trauma.backend.campaignCreation.monsterCreation.monster.repository.MonsterEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionService {
    private final ActionRepository actionRepository;

    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public List<Action> findAllActions() {
        return this.actionRepository.findAll()
                .stream()
                .map(Action::new)
                .toList();
    }

    public Optional<Action> findActionById(Long id) {
        return this.actionRepository.findById(id)
                .map(Action::new);
    }

    public Action createAction(Action action) {
        return new Action(this.actionRepository.save(new ActionEntity(action)));
    }

    public Action updateAction(Long id, Action action) throws ActionNotFoundException {
        Optional<Action> existingAction = this.actionRepository.findById(id)
                .map(Action::new);

        if (existingAction.isPresent()) {
            Action updatedAction = existingAction.get();
            updatedAction.setId(action.getId());
            updatedAction.setName(action.getName());
            updatedAction.setDescription(action.getDescription());
            updatedAction.setType(action.getType());
            updatedAction.setRarity(action.getRarity());
            updatedAction.setMonsters(action.getMonsters());

            return new Action(this.actionRepository.save(new ActionEntity(updatedAction)));
        }
        else {
            throw new ActionNotFoundException("Action not found with id: " + id);
        }
    }

    public void deleteAction(Long id) {
        this.actionRepository.deleteById(id);
    }
}
