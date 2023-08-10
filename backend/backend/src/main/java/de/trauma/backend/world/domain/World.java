package de.trauma.backend.world.domain;

import de.trauma.backend.world.repository.WorldEntity;

public class World {
    private Long id;
    private String name;
    private String system;

    public World(WorldEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.system = entity.getSystem();
    }

    public World(Long id, String name, String system) {
        this.id = id;
        this.name = name;
        this.system = system;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSystem() {
        return system;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
