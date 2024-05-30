package com.incident.repository;

import com.incident.model.Incident;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IncidentRepository extends CrudRepository<Incident, Integer> {

    @Modifying
    @Query("UPDATE Incident u SET u.incidentStatus = :incidentStatus WHERE u.incidentId = :incidentId")
    void updateStatus(@Param("incidentStatus") String incidentStatus, @Param("incidentId") String incidentId);

    @Modifying
    @Query("UPDATE Incident u SET u.priority = :priority, u.incidentDetail = :incidentDetail WHERE u.incidentId = :incidentId")
    void updateIncidentDetail(@Param("priority") String priority, @Param("incidentDetail") String incidentDetail, @Param("incidentId") String incidentId);

    Incident findByIncidentId(String incidentId);;
}
