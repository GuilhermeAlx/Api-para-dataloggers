package com.example.demo.arduino;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.example.demo.dado.Dado;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
  @Column(name = "id_arduino")
  private Long id;

  @Column(name = "descricao")
  String descricao;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(name = "status", columnDefinition = "char(1)")
  private ArduinoStatus arduinoStatus;

  // @OneToMany(mappedBy = "arduino", cascade = CascadeType.ALL)
  // @JsonIgnoreProperties({ "arduino" })
  // private List<Dado> dado;

  public Arduino(String descricao, ArduinoStatus arduinoStatus) {
    this.descricao = descricao;
    this.arduinoStatus = arduinoStatus;
  }

}
