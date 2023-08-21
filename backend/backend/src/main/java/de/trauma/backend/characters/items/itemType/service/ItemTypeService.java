package de.trauma.backend.characters.items.itemType.service;

import de.trauma.backend.characters.items.itemType.domain.ItemType;
import de.trauma.backend.characters.items.itemType.exceptions.ItemTypeNotFoundException;
import de.trauma.backend.characters.items.itemType.repository.ItemTypeEntity;
import de.trauma.backend.characters.items.itemType.repository.ItemTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemTypeService {
    private final ItemTypeRepository itemTypeRepository;

    public ItemTypeService(ItemTypeRepository itemTypeRepository) {
        this.itemTypeRepository = itemTypeRepository;
    }

    public List<ItemType> findAllItemTypes() {
        return this.itemTypeRepository.findAll()
                .stream()
                .map(ItemType::new)
                .toList();
    }

    public Optional<ItemType> findItemTypeById(Long id) {
        return this.itemTypeRepository.findById(id)
                .map(ItemType::new);
    }

    public ItemType createItemType(ItemType itemType) {
        return new ItemType(this.itemTypeRepository.save(new ItemTypeEntity(itemType)));
    }

    public ItemType updateItemType(Long id, ItemType itemType) {
        Optional<ItemType> existingItemType = this.itemTypeRepository.findById(id)
                .map(ItemType::new);

        if (existingItemType.isPresent()) {
            ItemType updatedItemType = existingItemType.get();
            updatedItemType.setId(itemType.getId());
            updatedItemType.setName(itemType.getName());
            updatedItemType.setDescription(itemType.getDescription());
            updatedItemType.setItems(itemType.getItems());

            return new ItemType(this.itemTypeRepository.save(new ItemTypeEntity(updatedItemType)));
        }
        else {
            throw new ItemTypeNotFoundException("Item Type could not be found with id: " + id);
        }
    }

    public void deleteItemType(Long id) {
        this.itemTypeRepository.deleteById(id);
    }
}
