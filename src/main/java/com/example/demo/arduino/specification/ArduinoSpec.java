package com.example.demo.arduino.specification;

import com.example.demo.arduino.Arduino;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Conjunction;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Conjunction(
  value = {},
  and = {
    @Spec(
      path = "descricaoArduino",
      params = "descricao",
      spec = LikeIgnoreCase.class
    ),
    @Spec(path = "arduinoId", params = "id", spec = Equal.class),
    @Spec(path = "status", params = "status", spec = Equal.class),
  }
)
public interface ArduinoSpec extends Specification<Arduino> {}
