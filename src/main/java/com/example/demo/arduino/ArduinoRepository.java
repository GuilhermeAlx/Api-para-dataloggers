package com.example.demo.arduino;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.example.demo.arduino.dtos.AtualizaArduinoDTO;

@Repository
@EnableJpaRepositories
public interface ArduinoRepository extends JpaRepositoryImplementation<Arduino, Long> {

}
