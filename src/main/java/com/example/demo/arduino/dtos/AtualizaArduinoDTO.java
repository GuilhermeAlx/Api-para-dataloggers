package com.example.demo.arduino.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;


@Data
public class AtualizaArduinoDTO {

    @NotBlank
    private Long id;

    @NotBlank
    private String descricao;

}
