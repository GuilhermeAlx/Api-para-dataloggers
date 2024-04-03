package com.example.demo.arduino;

import java.util.List;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ArduinoRepository
  extends
    CrudRepository<Arduino, Long>, JpaRepositoryImplementation<Arduino, Long> {
  List<Arduino> findAllByArduinoStatus(ArduinoStatus status);
}
