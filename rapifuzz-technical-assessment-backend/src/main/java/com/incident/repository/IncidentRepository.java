package com.incident.repository;

import com.incident.entity.IncidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<IncidentEntity, Long> {
    List<IncidentEntity> findByUserId(Long userId);
}
