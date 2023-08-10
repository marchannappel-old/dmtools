package de.trauma.backend.world.controller;

import de.trauma.backend.world.domain.World;

public class WorldDTO {
    private final Long id;
    private final String name;
    private final String system;

    public WorldDTO(World world) {
        this.id = world.getId();
        this.name = world.getName();
        this.system = world.getSystem();
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
}
