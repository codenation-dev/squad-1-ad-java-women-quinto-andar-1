package br.com.quintoandar.quintolog.entity.enums;

import lombok.Getter;

@Getter
public enum LevelLog {
    DEBUG("DEBUG"),
    ERROR("ERROR"),
    WARNING("WARNING");

    private String name;

    LevelLog(String name) {
        this.name = name;
    }
}

