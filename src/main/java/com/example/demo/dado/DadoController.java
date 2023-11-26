package com.example.demo.dado;

import java.util.EmptyStackException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.dado.dtos.DadoDTO;

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
    public Object index(@RequestParam String idString) {
        long id = Long.parseLong(idString);

        
        return ResponseEntity.ok(dadoRepository.findBy(idString));
    }

    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity store(@ModelAttribute @Valid DadoDTO dadoDTO) {

        System.out.println("\nPressao: " + dadoDTO.getPressaoAnalogico());

        Arduino arduino = arduinoRepository.getOne(dadoDTO.getArduinoId());
        System.out.println("id: "+arduino.getId());

        if (arduino.getId() != null) {
            Dado dado = new Dado(arduino, dadoDTO.getPressaoAnalogico(), dadoDTO.getFrequencia(),
                    dadoDTO.getVazao(), dadoDTO.getPressaoProcessada());
            System.out.println("\n\nData: " + dado.getData().toString());
            return ResponseEntity.ok().body(dadoRepository.save(dado));
        } else {
            System.out.println("Naou achou");
            throw new EmptyStackException();
        }
    }

}
    