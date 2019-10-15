package br.com.quintoandar.quintolog.entity;

import br.com.quintoandar.quintolog.entity.enums.Level;
import br.com.quintoandar.quintolog.entity.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.security.Timestamp;

@Getter
@Setter
@Entity
public class Log {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column(name = "number_events")
    private Long numberEvents;

    @Size(max = 11)
    @NotNull
    @Column(name = "level")
    private Level level;

    @NotNull
    @Column(name = "status")
    private Status status;

    @NotNull
    @Column(name = "environment")
    private Long environment;

    @NotNull
    @Size(max = 100)
    @Column(name = "description")
    private String description;

    @NotNull
    @Size(max = 100)
    @Column(name = "details")
    private String details;

    @NotNull
    @Column(name = "created_at")
    private Timestamp createdAt;

    @NotNull
    @Column(name = "user_id")
    private Long userId;

}
