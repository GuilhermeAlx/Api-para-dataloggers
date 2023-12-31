package com.example.demo.arduino;

import java.util.List;

import com.example.demo.dado.Dado;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "arduino")
@NoArgsConstructor
@AllArgsConstructor
public class Arduino {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @EqualsAndHashCode.Include
  @Column(name="id_arduino")
  Long id;

  @Column(name = "descricao")
  String descricao;

  @Column(name= "status")
  ArduinoStatus arduinoStatus;

  
  @OneToMany(mappedBy = "arduino", cascade = CascadeType.ALL)
  @JsonIgnoreProperties({ "arduino" })
  List<Dado> dado;

  public Arduino(String descricao) {
    this.descricao = descricao;
  }

}
