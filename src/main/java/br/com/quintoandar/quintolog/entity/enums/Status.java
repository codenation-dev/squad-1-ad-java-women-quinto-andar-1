package br.com.quintoandar.quintolog.entity.enums;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    OTHERS("OTHERS");

    private String name;

    Status(String name) {
        this.name = name;
    }
}
