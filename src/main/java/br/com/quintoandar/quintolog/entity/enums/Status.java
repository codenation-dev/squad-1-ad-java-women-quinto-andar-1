package br.com.quintoandar.quintolog.entity.enums;

import lombok.Getter;
import lombok.Setter;

import java.util.stream.Stream;

@Getter
public enum Status {
    ACTIVE("ACTIVE"),
    ARCHIVED("ARCHIVED"),
    DELETED("DELETED");

    private String name;

    Status(String name) {
        this.name = name;
    }

    public static Status getStatus(String name) {
        return Stream.of(values())
                .filter(value -> name.equals(value.name))
                .findAny()
                .get();
    }
}
