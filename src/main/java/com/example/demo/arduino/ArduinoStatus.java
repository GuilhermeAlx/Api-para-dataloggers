package com.example.demo.arduino;

public enum  ArduinoStatus {
    A("Ativo"), B("Bloqueado"), D("Desativado");

    private String descricao;

    ArduinoStatus(String descricao) {
        this.descricao = descricao;
    }

    public String descricao() {
        return descricao;
    }

}
