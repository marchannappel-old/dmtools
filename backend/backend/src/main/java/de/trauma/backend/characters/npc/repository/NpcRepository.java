package de.trauma.backend.characters.npc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NpcRepository extends JpaRepository<NpcEntity, Long> {
}
