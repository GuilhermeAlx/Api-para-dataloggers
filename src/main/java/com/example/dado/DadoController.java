package com.example.dado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dado.dtos.DadoDTO;
import com.example.demo.arduino.Arduino;
import com.example.demo.arduino.ArduinoRepository;

@RestController
@RequestMapping("/api/Dado")
public class DadoController {

    @Autowired
    DadoRepository DadoRepository;

    @Autowired
    ArduinoRepository arduinoRepository;

    @GetMapping("/dadosArduino")
    public Object index(@RequestParam String idString) {
        long id = Long.parseLong(idString);
        return ResponseEntity.ok(DadoRepository.findAllByArduinoId(id));
    }

    @PostMapping("/insere-Dados")
    public ResponseEntity Object(@RequestBody DadoDTO dadoDTO) {

        Arduino arduino = arduinoRepository.getOne(dadoDTO.getArduinoId());

        if (arduino != null) {
            Dado Dado = new Dado(dadoDTO.getArduinoId(), dadoDTO.getPressaoAnalogico(), dadoDTO.getFrequencia(),
                    dadoDTO.getVazao(), dadoDTO.getPressaoProcessada());
            return ResponseEntity.ok().body(DadoRepository.save(Dado));
        }else{
            return ResponseEntity.ofNullable(arduino);
        }
    }

}
