package com.example.demo.dado;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.util.PropertySource.Comparator;
import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.arduino.Arduino;
import com.example.demo.arduino.ArduinoController;
import com.example.demo.arduino.ArduinoRepository;
import com.example.demo.arduino.dtos.DescricaoArduino;
import com.example.demo.dado.dtos.DadoDTO;
import com.example.demo.dado.dtos.ListaUltimoDadoSalvoPorSensorDTO;
import org.springframework.data.domain.Sort.Direction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/api/dado")
public class DadoController {

    @Autowired
    DadoRepository dadoRepository;

    @Autowired
    ArduinoController arduinoController;

    @Autowired
    ArduinoRepository arduinoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/dadosArduino")
    public ResponseEntity<Object> index(@RequestParam String idString) {
        long id = Long.parseLong(idString);
        Pageable page = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(Sort.Direction.DESC, "data"));
        return ResponseEntity.ok(dadoRepository.findAllByArduinoId(id, page));
    }

    @GetMapping("/dados-supervisorio")
    public List<ListaUltimoDadoSalvoPorSensorDTO> retornaUltimoDados() {

        List<Arduino> arduinos = arduinoRepository.findAll();

        List<ListaUltimoDadoSalvoPorSensorDTO> dados = new ArrayList<>();

        for (Arduino arduino : arduinos) {
            List<Dado> dadosArduino = arduino.getDado();
            dadosArduino.sort((p1, p2) -> p1.getData().compareTo(p2.getData()));
            ListaUltimoDadoSalvoPorSensorDTO listaUltimoDadoSalvoPorSensorDTO = new ListaUltimoDadoSalvoPorSensorDTO(
                    arduino.getId(), arduino.getDescricao(), dadosArduino.get(dadosArduino.size() - 1));
            dados.add(listaUltimoDadoSalvoPorSensorDTO);
        }

        return dados;
    }

    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity store(@ModelAttribute @Valid DadoDTO dadoDTO) {

        Arduino arduino = arduinoRepository.getOne(dadoDTO.getArduinoId());
        if (arduino.getId() != null) {
            Dado dado = new Dado(arduino, dadoDTO.getPressaoAnalogico(), dadoDTO.getFrequencia(),
                    dadoDTO.getVazao(), dadoDTO.getPressaoProcessada());
            System.out.println("\n\nData: " + dado.getData().toString());
            return ResponseEntity.ok().body(null);
        } else {
            throw new EmptyStackException();
        }
    }

}
