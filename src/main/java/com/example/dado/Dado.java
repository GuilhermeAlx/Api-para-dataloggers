package com.example.dado;

import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "dados")
@AttributeOverride(name = "id", column = @Column(name = "id", columnDefinition = "NUMBER(10)"))
public class Dado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Dado(Long i, int pressaoAnalogico,int frequencia, float vazao, float pressaoProcessada ){
        this.arduinoId=i;
        this.pressaoAnalogico=pressaoAnalogico;
        this.frequencia=frequencia;
        this.vazao=vazao;
        this.pressaoProcessada=pressaoProcessada;
        this.data=new Date();
    }

}
