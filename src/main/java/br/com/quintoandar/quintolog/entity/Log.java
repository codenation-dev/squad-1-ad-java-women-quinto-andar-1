package br.com.quintoandar.quintolog.entity;

import br.com.quintoandar.quintolog.entity.enums.Environment;
import br.com.quintoandar.quintolog.entity.enums.Level;
import br.com.quintoandar.quintolog.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

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
    @JsonProperty(value = "number_events")
    private Long numberEvents;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "level")
    private Level level;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "environment")
    private Environment environment;

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
    @JsonProperty(value = "created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "user_id")
    @JsonProperty(value = "user_id")
    private Long userId;

}
