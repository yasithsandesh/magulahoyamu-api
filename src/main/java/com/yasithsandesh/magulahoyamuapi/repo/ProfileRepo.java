package com.yasithsandesh.magulahoyamuapi.repo;


import com.yasithsandesh.magulahoyamuapi.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ProfileRepo  extends JpaRepository<Profile, Long> {
}
