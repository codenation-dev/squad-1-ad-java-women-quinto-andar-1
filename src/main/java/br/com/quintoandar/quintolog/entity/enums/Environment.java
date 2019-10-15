package br.com.quintoandar.quintolog.entity.enums;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum Environment {

    PRODUCTION(1, "PRODUCTION"),
    HOMOLOGATION(2, "HOMOLOGATION"),
    DEV(3, "DEV"),
    OTHERS(4, "OTHERS");

    private int id;
    private String name;

    Environment(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Environment getEnvironment(int environmentId) {
        return Stream.of(values())
                .filter(value -> environmentId == value.id)
                .findAny()
                .orElse(OTHERS);
    }


}
