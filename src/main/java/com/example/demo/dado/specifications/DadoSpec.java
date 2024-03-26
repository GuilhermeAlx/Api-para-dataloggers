package com.example.demo.dado.specifications;

import jakarta.persistence.criteria.JoinType;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Conjunction;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@Join(path = "arduino", alias = "arduino", type = JoinType.LEFT)
@Conjunction(value = {}, and = {
        @Spec(path = "descricao", params = "arduino.descricao", spec = LikeIgnoreCase.class),
        @Spec(path = "arduinoId", params = "arduino.id", spec = Equal.class),
}

)
public interface DadoSpec {
}
