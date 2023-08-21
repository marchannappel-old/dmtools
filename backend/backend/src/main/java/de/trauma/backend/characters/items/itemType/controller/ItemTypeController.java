package de.trauma.backend.characters.items.itemType.controller;

import de.trauma.backend.characters.items.itemType.domain.ItemType;
import de.trauma.backend.characters.items.itemType.service.ItemTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemtypes")
public class ItemTypeController {
    private final ItemTypeService itemTypeService;

    public ItemTypeController(ItemTypeService itemTypeService) {
        this.itemTypeService = itemTypeService;
    }

    @GetMapping
    public List<ItemTypeDTO> list() {
        return this.itemTypeService.findAllItemTypes()
                .stream()
                .map(ItemTypeDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ItemTypeDTO read(@PathVariable Long id) {
        return this.itemTypeService.findItemTypeById(id)
                .map(ItemTypeDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public ItemTypeDTO create(@RequestBody ItemType itemType) {
        return new ItemTypeDTO(this.itemTypeService.createItemType(itemType));
    }

    @PutMapping("/{id}")
    public ItemTypeDTO update(@PathVariable Long id, @RequestBody ItemType itemType) {
        return new ItemTypeDTO(this.itemTypeService.updateItemType(id, itemType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.itemTypeService.deleteItemType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
