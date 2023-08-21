package de.trauma.backend.characters.items.item.controller;

import de.trauma.backend.characters.items.item.domain.Item;
import de.trauma.backend.characters.items.item.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<ItemDTO> list() {
        return this.itemService.findAllItems()
                .stream()
                .map(ItemDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ItemDTO read(@PathVariable Long id) {
        return this.itemService.findItemById(id)
                .map(ItemDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public ItemDTO create(@RequestBody Item item) {
        return new ItemDTO(this.itemService.createItem(item));
    }

    @PutMapping("/{id}")
    public ItemDTO update(@PathVariable Long id, @RequestBody Item item) {
        return new ItemDTO(this.itemService.updateItem(id, item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
