package com.example.demo.dado;

import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name="dado")
@NoArgsConstructor
@AllArgsConstructor
public class Dado {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @EqualsAndHashCode.Include
    Long id;

        // @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        // @JoinColumn(name = "idArduino", foreignKey = @ForeignKey(name = "arduino"))
        // Arduino arduino;

    private Long arduinoId;

    @Column(name = "pressao")
    private int pressaoAnalogico;

    @Column(name = "frequencia")
    private int frequencia;

    @Column(name = "vazao")
    private float vazao;

    @Column(name = "pressaoProcessada")
    private float pressaoProcessada;

    @UpdateTimestamp
    @Column(name = "data", nullable = true, columnDefinition = "DATE")
    private Date data;

    public Dado(Long arduinoId, int pressaoAnalogico,int frequencia, float vazao, float pressaoProcessada ){
        this.arduinoId=arduinoId;
        this.pressaoAnalogico=pressaoAnalogico;
        this.frequencia=frequencia;
        this.vazao=vazao;
        this.pressaoProcessada=pressaoProcessada;
        this.data=new Date();
    }

}
