package com.example.demo.arduino;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="arduino")
@NoArgsConstructor
@AllArgsConstructor
public class Arduino {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequencia_generator")
  @EqualsAndHashCode.Include
    Long id;

    @Column(name = "descricao")
    String descricao;

    public Arduino(String descricao) {
        this.descricao = descricao;
    }

}
