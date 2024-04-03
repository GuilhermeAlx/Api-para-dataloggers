package com.example.demo.dado.specifications;

import com.example.demo.dado.Dado;
import jakarta.persistence.criteria.JoinType;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Conjunction;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Join(path = "arduino", alias = "arduino", type = JoinType.LEFT)
@Conjunction(
  value = {
    @Or(
      {
        @Spec(
          path = "descricao",
          params = "arduino.descricao",
          spec = LikeIgnoreCase.class
        ),
        @Spec(
          path = "arduinoId",
          params = "arduino.id",
          spec = LikeIgnoreCase.class
        ),
      }
    ),
  },
  and = {
    @Spec(
      path = "descricaoArduino",
      params = "arduino.descricao",
      spec = LikeIgnoreCase.class
    ),
    @Spec(path = "arduinoId", params = "arduino.id", spec = Equal.class),
    @Spec(path = "status", params = "arduino.status", spec = Equal.class),
  }
)
public interface DadoSpecs extends Specification<Dado> {}
