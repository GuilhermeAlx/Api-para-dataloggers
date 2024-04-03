package com.example.demo.arduino;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ArduinoStatus {
  A("ATIVO"),
  B("BLOQUEADO"),
  I("INATIVO");

  private final String ArduinoStatus;

  private ArduinoStatus(final String ArduinoStatus) {
    this.ArduinoStatus = ArduinoStatus;
  }

  public String getValue() {
    return this.name();
  }
}
