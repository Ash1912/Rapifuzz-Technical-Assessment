package com.incident.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "incidents")
public class IncidentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String LastName;
    private String emailId;
}
