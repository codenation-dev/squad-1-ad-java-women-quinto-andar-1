package br.com.quintoandar.quintolog.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Status {
    ACTIVE(01, "ATIVO"),
    INACTIVE(02, "ATIVO"),
    OTHERS(0, "ATIVO");
    private int id;
    private String name;

    public static Status getStatus(int statusId) {
        return Stream.of(values())
                .filter(value -> statusId == value.id)
                .findAny()
                .orElse(OTHERS);
    }
}
