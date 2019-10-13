package br.com.quintoandar.quintolog.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
public enum Level {

    DEBUG(1, "DEBUG"),
    ERROR(2, "ERROR"),
    WARNING(3, "WARNING"),
    OTHERS(4, "OTHERS");

    private int id;
    private String name;
    
    Level(int id, String name){
    	this.id = id;
    	this.name = name;
    }

    public static Level getLevel(int levelId) {
        return Stream.of(values())
                .filter(value -> levelId == value.id)
                .findAny()
                .orElse(OTHERS);
    }
}
