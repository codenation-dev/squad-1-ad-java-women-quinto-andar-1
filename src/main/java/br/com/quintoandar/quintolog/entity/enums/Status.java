package br.com.quintoandar.quintolog.entity.enums;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum Status {
    ACTIVE(1, "ACTIVE"),
    INACTIVE(2, "INACTIVE"),
    OTHERS(3, "OTHERS");

    private int id;
    private String name;

    Status(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Status getStatus(int statusId) {
        return Stream.of(values())
                .filter(value -> statusId == value.id)
                .findAny()
                .orElse(OTHERS);
    }
}
