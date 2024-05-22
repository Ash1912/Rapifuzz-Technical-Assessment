package com.incident.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Incident {
    private Long id;
    private String firstName;
    private String LastName;
    private String emailId;
}