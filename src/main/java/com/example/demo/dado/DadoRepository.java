package com.example.demo.dado;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.demo.dado.dtos.DadoDTO;

public interface DadoRepository extends JpaRepositoryImplementation<Dado, Long> {

    Page<Dado> findAllByArduinoId(Long id, Pageable page);

    Dado findFirstByArduinoIdOrderByDataAsc(Long id);

    void save(@Valid DadoDTO dadoDTO);
}
