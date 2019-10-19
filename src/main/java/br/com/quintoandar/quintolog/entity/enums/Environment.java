package br.com.quintoandar.quintolog.entity.enums;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum Environment {

    PRODUCTION("PRODUCTION"),
    HOMOLOGATION("HOMOLOGATION"),
    DEV("DEV"),
    OTHERS("OTHERS");

    private String name;

    Environment(String name) {
        this.name = name;
    }
}
