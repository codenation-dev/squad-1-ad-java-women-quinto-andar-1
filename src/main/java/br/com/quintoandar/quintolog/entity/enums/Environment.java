package br.com.quintoandar.quintolog.entity.enums;

import lombok.Getter;

@Getter
public enum Environment {

    PRODUCTION("PRODUCTION"),
    HOMOLOG("HOMOLOG"),
    DEV("DEV");

    private String name;

    Environment(String name) {
        this.name = name;
    }
}
