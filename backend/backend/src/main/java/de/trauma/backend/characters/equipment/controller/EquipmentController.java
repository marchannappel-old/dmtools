package de.trauma.backend.characters.equipment.controller;

import de.trauma.backend.characters.equipment.domain.Equipment;
import de.trauma.backend.characters.equipment.service.EquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipments")
public class EquipmentController {
    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public List<EquipmentDTO> list() {
        return this.equipmentService.findAllEquipments()
                .stream()
                .map(EquipmentDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public EquipmentDTO read(@PathVariable Long id) {
        return this.equipmentService.findEquipmentById(id)
                .map(EquipmentDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public EquipmentDTO create(@RequestBody Equipment equipment) {
        return new EquipmentDTO(this.equipmentService.createEquipment(equipment));
    }

    @PutMapping("/{id}")
    public EquipmentDTO update(@PathVariable Long id, @RequestBody Equipment equipment) {
        return new EquipmentDTO(this.equipmentService.updateEquipment(id, equipment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.equipmentService.deleteEquipment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
