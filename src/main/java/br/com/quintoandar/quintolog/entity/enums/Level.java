package br.com.quintoandar.quintolog.entity.enums;

import lombok.Getter;

import javax.validation.constraints.Size;

@Getter
public enum Level {
    DEBUG("DEBUG"),
    ERROR("ERROR"),
    WARNING("WARNING"),
    OTHERS("OTHERS");

    @Size(max = 11)
    private String name;

    Level(String name) {
        this.name = name;
    }
}

