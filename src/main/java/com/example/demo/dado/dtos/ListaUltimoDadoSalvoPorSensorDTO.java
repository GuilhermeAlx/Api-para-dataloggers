package com.example.demo.dado.dtos;

import com.example.demo.dado.Dado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ListaUltimoDadoSalvoPorSensorDTO {

    Long id;

    String descricao;

    Dado dado;

    public ListaUltimoDadoSalvoPorSensorDTO(Long id,String descricao,Dado dado){
        this.id=id;
        this.descricao=descricao;
        this.dado=dado;
    }
}
