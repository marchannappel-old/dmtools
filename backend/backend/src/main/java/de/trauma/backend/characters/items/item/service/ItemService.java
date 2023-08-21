package de.trauma.backend.characters.items.item.service;

import de.trauma.backend.characters.items.item.domain.Item;
import de.trauma.backend.characters.items.item.exceptions.ItemNotFoundException;
import de.trauma.backend.characters.items.item.repository.ItemEntity;
import de.trauma.backend.characters.items.item.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAllItems() {
        return this.itemRepository.findAll()
                .stream()
                .map(Item::new)
                .toList();
    }

    public Optional<Item> findItemById(Long id) {
        return this.itemRepository.findById(id)
                .map(Item::new);
    }

    public Item createItem(Item item) {
        return new Item(this.itemRepository.save(new ItemEntity(item)));
    }

    public Item updateItem(Long id, Item item) {
        Optional<Item> existingItem = this.itemRepository.findById(id)
                .map(Item::new);

        // TODO: complete mapping here
        if (existingItem.isPresent()) {
            Item updatedItem = existingItem.get();
            updatedItem.setId(item.getId());
            updatedItem.setName(item.getName());
            updatedItem.setDescription(item.getDescription());
            updatedItem.setQuantity(item.getQuantity());
            updatedItem.setWeight(item.getWeight());
            updatedItem.setCapacity(item.getCapacity());
            updatedItem.setCost(item.getCost());
            updatedItem.setProficient(item.isProficient());
            updatedItem.setAttackType(item.getAttackType());
            updatedItem.setReach(item.getReach());
            updatedItem.setDamage(item.getDamage());
            updatedItem.setDamageType(item.getDamageType());
            updatedItem.setArmorClass(item.getArmorClass());
            updatedItem.setItemTypes(item.getItemTypes());
            updatedItem.setItemCategories(item.getItemCategories());

            return new Item(this.itemRepository.save(new ItemEntity(updatedItem)));
        }
        else {
            throw new ItemNotFoundException("Item could not be found with id: " + id);
        }
    }

    public void deleteItem(Long id) {
        this.itemRepository.deleteById(id);
    }
}
