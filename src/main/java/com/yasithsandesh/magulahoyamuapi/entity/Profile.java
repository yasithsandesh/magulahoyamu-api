package com.yasithsandesh.magulahoyamuapi.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "profile")
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "birth_year", nullable = false)
    private int birthYear;

    @Column(name = "education_level", length = 100)
    private String educationLevel;

    @Column(name = "job", length = 100)
    private String job;

    @Column(name = "height", length = 20)
    private String height;

    @Column(name = "text", columnDefinition = "TEXT")
    private String text;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "city", length = 100)
    private String city;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "profile_id",
            referencedColumnName = "id",
            nullable = false
    )

    private PartnerPreference partnerPreference;

}
