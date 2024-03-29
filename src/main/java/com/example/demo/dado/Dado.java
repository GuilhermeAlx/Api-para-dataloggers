package com.example.demo.dado;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.arduino.Arduino;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "dado")
@NoArgsConstructor
@AllArgsConstructor
public class Dado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "sequencia_nome_Dado", initialValue = 101)
    @EqualsAndHashCode.Include
    @Column(name = "id_dado")
    Long id;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "id_arduino", foreignKey = @ForeignKey(name = "arduino"))
    private Arduino arduino;

    @Column(name = "pressao")
    private int pressaoAnalogico;

    @Column(name = "frequencia")
    private int frequencia;

    @Column(name = "vazao")
    private float vazao;

    @Column(name = "pressaoProcessada")
    private float pressaoProcessada;

    @DateTimeFormat(pattern = "dd-MM-dd'T'HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "startDateTime", nullable = true, columnDefinition = "TIMESTAMP")
    private Date data;

    public Dado(Arduino arduino, int pressaoAnalogico, int frequencia, float vazao, float pressaoProcessada) {
        this.arduino = arduino;
        this.pressaoAnalogico = pressaoAnalogico;
        this.frequencia = frequencia;
        this.vazao = vazao;
        this.pressaoProcessada = pressaoProcessada;
        this.data = new Date();
    }

}
