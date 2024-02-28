package com.example.demo.dado;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface DadoRepository extends JpaRepositoryImplementation<Dado, Long> {

    Page<Dado> findAllByArduinoId(Long id, Pageable page);

    Dado findFirstByArduinoIdOrderByDataAsc(Long id);
}
