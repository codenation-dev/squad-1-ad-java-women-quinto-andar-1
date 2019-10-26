package br.com.quintoandar.quintolog.controller.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
@Setter
public class LoginForm {

    private String email;
    private String password;

    public UsernamePasswordAuthenticationToken toConvert(){
        return new UsernamePasswordAuthenticationToken(this.email, this.password);
    }
}
