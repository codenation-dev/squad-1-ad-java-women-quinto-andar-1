package br.com.quintoandar.quintolog.entity;

import br.com.quintoandar.quintolog.entity.enums.Status;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Log {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long numberEvents;
    private Status status;
    private Long environment;
    private String description;
    private String details;
    private LocalDateTime timestamp;
    private Long userId;


//    private Long idConta;
//    private Long id
//    NOTNULL,
//    @Size(min = 11, max = 11)
//    private String level
//
//    VARCHAR(100) NOTNULL,
//
//    privateevents
//    int NOTNULL,
//
//    privatestatus VARCHAR(100) NOTNULL,
//
//    privateenvironment
//    int NOTNULL,
//
//    private description VARCHAR(100) NOTNULL,
//
//    private details VARCHAR(100) NOTNULL,
//
//    private date timestamp
//    NOTNULL,
//    private userId
//    int NOTNULL,
//
//    PRIMARY KEY(id),
//
//    FOREIGN KEY(userId) REFERENCES(userId)

}
