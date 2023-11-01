package com.example.demo.dado;

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
import com.example.demo.arduino.ArduinoRepository;
import com.example.demo.dado.dtos.DadoDTO;

@RestController
@RequestMapping("/api/dado")
public class DadoController {

    @Autowired
    DadoRepository dadoRepository;

    @Autowired
    ArduinoRepository arduinoRepository;

    @GetMapping("/dadosArduino")
    public Object index(@RequestParam String idString) {
        long id = Long.parseLong(idString);
        return ResponseEntity.ok(dadoRepository.findAllByArduinoId(id));
    }

    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity store(@ModelAttribute @Valid DadoDTO dadoDTO) {

        Arduino arduino = arduinoRepository.getOne(dadoDTO.getArduinoId());

        System.out.println("\nPressao: "+dadoDTO.getPressaoAnalogico());

        if (arduino != null) {
            Dado dado = new Dado(dadoDTO.getArduinoId(), dadoDTO.getPressaoAnalogico(), dadoDTO.getFrequencia(),
                    dadoDTO.getVazao(), dadoDTO.getPressaoProcessada());
                    System.out.println("\n\nData: "+dado.getData().toString());
            return ResponseEntity.ok().body(dadoRepository.save(dado));
        }else{
            return ResponseEntity.ofNullable(arduino);
        }
    }

}
