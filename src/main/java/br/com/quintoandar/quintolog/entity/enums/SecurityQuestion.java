package br.com.quintoandar.quintolog.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum SecurityQuestion {

    TEACHER(1, "logError.question1"),
    ANIMAL(2, "logError.question2"),
    FILM(3, "logError.question3");

    private int id;
    private String name;

    public static SecurityQuestion getSecurityQuestion(int securityQuestionId) {
        return Stream.of(values())
                .filter(value -> securityQuestionId == value.id)
                .findAny()
                .get();
    }
}
