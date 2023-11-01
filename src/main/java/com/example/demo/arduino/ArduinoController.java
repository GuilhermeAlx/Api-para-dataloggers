package com.example.demo.arduino;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.arduino.dtos.AtualizaArduinoDTO;

@RestController
@RequestMapping("/api/arduino")
public class ArduinoController {

    @Autowired
    ArduinoRepository arduinoRepository;

    @GetMapping("/existe-arduino")
    public boolean getArduinoExist(@RequestParam String idString) {
        long id = Long.parseLong(idString);

        return  arduinoRepository.existsById(id);
    }

    @GetMapping("/descreve-dispositivo")
    public ResponseEntity getDescricao(@RequestParam String idString) {
        long id = Long.parseLong(idString);
        
        return  ResponseEntity.ok().body(arduinoRepository.findById(id));
    }

    @PostMapping("/cria-novo-id/")
    public ResponseEntity store(@RequestParam String descricao) {
        Arduino arduino = new Arduino(descricao);
        return ResponseEntity.ok().body(arduinoRepository.save(arduino));
    }

    @DeleteMapping("/")
    public ResponseEntity deletaControlador(@RequestParam String id) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Não é possível deletar um microcontrolador. Somente editar a sua descrição");
    }
    

    @PostMapping("/atualizar-arduino")
    public ResponseEntity atualizaDescricao(@RequestBody @Valid AtualizaArduinoDTO atualizaArduinoDTO){
        Arduino arduino=arduinoRepository.getOne(atualizaArduinoDTO.getId());
        arduino.setDescricao(atualizaArduinoDTO.getDescricao());
        return ResponseEntity.ok().body(arduinoRepository.save(arduino));

    }



}
