package br.com.quintoandar.quintolog.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
public enum Status {
	ACTIVE(1, "ATIVO"),
    INACTIVE(2, "INATIVO"),
    OTHERS(3, "OUTROS");
	
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
