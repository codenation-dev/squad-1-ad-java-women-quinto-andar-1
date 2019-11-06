package br.com.quintoandar.quintolog.entity;

import br.com.quintoandar.quintolog.entity.enums.Environment;
import br.com.quintoandar.quintolog.entity.enums.LevelLog;
import br.com.quintoandar.quintolog.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class LogError {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "title")
    private String title;

    @JsonProperty(value = "number_events")
    private Long numberEvents;

    @NotNull
    @Column(name = "level_log")
    @JsonProperty(value = "level_log")
    @Enumerated(EnumType.STRING)
    private LevelLog levelLog;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    @Column(name = "environment")
    @Enumerated(EnumType.STRING)
    private Environment environment;

    @NotNull
    @Size(max = 100)
    @Column(name = "description")
    private String description;

    @Size(max = 100)
    @Column(name = "details")
    private String details;

    @NotNull
    @Size(max = 45)
    @Column(name = "ip")
    private String ip;

    @NotNull
    @Column(name = "stack_trace")
    @JsonProperty(value = "stack_trace")
    private String stackTrace;

    @Column(name = "user_id")
    @JsonProperty(value = "user_id")
    private Long userId;

    @Column(name = "source_application")
    @JsonProperty(value = "source_application")
    private String sourceApplication;

    @Column(name = "created_at")
    @JsonProperty(value = "created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt = LocalDateTime.now();

}
