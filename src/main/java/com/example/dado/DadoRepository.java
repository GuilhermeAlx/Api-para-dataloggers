package com.example.dado;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface DadoRepository extends JpaRepositoryImplementation<Dado, Long> {
    
    List<Dado> findAllByArduinoId(Long id);
}
