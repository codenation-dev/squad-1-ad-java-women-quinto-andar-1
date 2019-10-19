package br.com.quintoandar.quintolog.entity.enums;

import lombok.Getter;

@Getter
public enum Level {
    DEBUG("DEBUG"),
    ERROR("ERROR"),
    WARNING("WARNING"),
    OTHERS("OTHERS");

    private String name;

    Level(String name) {
        this.name = name;
    }
}

