package com.yasithsandesh.magulahoyamuapi.dto.request;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "partner_preference")
@Data
public class PartnerPreferenceDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "preferred_height", length = 20)
    private String preferredHeight;

    @Column(name = "preferred_education", length = 100)
    private String preferredEducation;

    @Column(name = "preferred_job", length = 100)
    private String preferredJob;

    @Column(name = "preferred_location", length = 150)
    private String preferredLocation;

    @Column(name = "smoking_allowed", nullable = false)
    private boolean smokingAllowed;

    @Column(name = "drinking_allowed", nullable = false)
    private boolean drinkingAllowed;
}
