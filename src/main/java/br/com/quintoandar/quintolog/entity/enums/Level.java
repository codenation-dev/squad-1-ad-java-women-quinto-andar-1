package br.com.quintoandar.quintolog.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Level {

    DEBUG(01, "DEBUG"),
    ERROR(02, "ERROR"),
    WARNING(03, "WARNING"),
    OTHERS(04, "OTHERS");

    private int id;
    private String name;

    public static Level getLevel(int levelId) {
        return Stream.of(values())
                .filter(value -> levelId == value.id)
                .findAny()
                .orElse(OTHERS);
    }
}
