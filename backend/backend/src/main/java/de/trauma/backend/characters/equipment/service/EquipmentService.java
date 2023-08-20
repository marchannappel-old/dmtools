package de.trauma.backend.characters.equipment.service;

import de.trauma.backend.characters.equipment.domain.Equipment;
import de.trauma.backend.characters.equipment.exceptions.EquipmentNotFoundException;
import de.trauma.backend.characters.equipment.repository.EquipmentEntity;
import de.trauma.backend.characters.equipment.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<Equipment> findAllEquipments() {
        return this.equipmentRepository.findAll()
                .stream()
                .map(Equipment::new)
                .toList();
    }

    public Optional<Equipment> findEquipmentById(Long id) {
        return this.equipmentRepository.findById(id)
                .map(Equipment::new);
    }

    public Equipment createEquipment(Equipment equipment) {
        return new Equipment(this.equipmentRepository.save(new EquipmentEntity(equipment)));
    }

    public Equipment updateEquipment(Long id, Equipment equipment) {
        Optional<Equipment> existingEquipment = this.equipmentRepository.findById(id)
                .map(Equipment::new);

        if (existingEquipment.isPresent()) {
            Equipment updatedEquipment = existingEquipment.get();
            updatedEquipment.setId(equipment.getId());
            updatedEquipment.setArmor(equipment.getArmor());
            updatedEquipment.setWeapons(equipment.getWeapons());
            updatedEquipment.setTools(equipment.getTools());
            updatedEquipment.setProficiencies(equipment.getProficiencies());

            return new Equipment(this.equipmentRepository.save(new EquipmentEntity(updatedEquipment)));
        }
        else {
            throw new EquipmentNotFoundException("Equipment could not be found with id: " + id);
        }
    }

    public void deleteEquipment(Long id) {
        this.equipmentRepository.deleteById(id);
    }
}
