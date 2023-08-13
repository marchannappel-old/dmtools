package de.trauma.backend.campaigns.sessions.sessionlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionLogRepository extends JpaRepository<SessionLogEntity, Long> {
}
