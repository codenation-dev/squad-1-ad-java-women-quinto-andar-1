package br.com.quintoandar.quintolog.entity;

import br.com.quintoandar.quintolog.entity.enums.Level;
import br.com.quintoandar.quintolog.entity.enums.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;

@Getter
@Setter
@Entity
public class Log {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "number_events")
    @NotNull
    private Long numberEvents;
    
    @Column(name = "level")
    @NotNull
    @Max(11)
    private Level level;
    
    @Column(name = "status")
    @NotNull
    private Status status;
    
    @Column(name = "environment")
    @NotNull
    private Long environment;
    
    @Column(name = "description")
    @NotNull
    private String description;
    
    @Column(name = "details")
    @NotNull
    private String details;
    
    @Column(name = "created_at")
    @NotNull
    private Timestamp createdAt;
    
    @Column(name = "user_id")
    @NotNull
    private Long userId;

}
