package com.example.demo.dado;

import com.example.demo.dado.dtos.DadoDTO;
import java.util.List;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadoRepository extends CrudRepository<Dado, Long> {
  Page<Dado> findAllByArduinoId(Long id, Pageable page);

  List<Dado> findByArduinoId(Long id, Pageable page);

  void save(@Valid DadoDTO dadoDTO);
}
