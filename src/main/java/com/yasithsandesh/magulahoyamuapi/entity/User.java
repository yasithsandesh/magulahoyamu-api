package com.yasithsandesh.magulahoyamuapi.entity;


import com.yasithsandesh.magulahoyamuapi.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "app_user")
@Data
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    private long id;

    @Column(nullable = false, name = "name", length = 60)
    private String name;

    @Column(nullable = false,name = "email", unique = true)
    private String email;

    @Column(nullable = false,name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name = "gender")
    private Gender gender;

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
    private Profile profile;

}
