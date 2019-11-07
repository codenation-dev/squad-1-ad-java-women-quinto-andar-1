package br.com.quintoandar.quintolog.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Profile implements GrantedAuthority {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Size(min = 3, max = 100)
    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
