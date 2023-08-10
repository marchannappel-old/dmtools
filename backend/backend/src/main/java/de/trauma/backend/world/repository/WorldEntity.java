package de.trauma.backend.world.repository;

import de.trauma.backend.world.domain.World;

import javax.persistence.*;

@Entity
@Table
public class WorldEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String system;

    public WorldEntity() {
    }

    public WorldEntity(Long id, String name, String system) {
        this.id = id;
        this.name = name;
        this.system = system;
    }

    public WorldEntity(World world) {
        this.id = world.getId();
        this.name = world.getName();
        this.system = world.getSystem();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
