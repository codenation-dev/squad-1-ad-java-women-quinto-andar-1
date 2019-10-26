package br.com.quintoandar.quintolog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import br.com.quintoandar.quintolog.controller.form.LoginForm;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.Valid;

@RestController
@RequestMapping("/oauth/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody @Valid LoginForm form){

        UsernamePasswordAuthenticationToken dataLogin = form.toConvert();

        try{
            Authentication authentication = authManager.authenticate(dataLogin);

            return ResponseEntity.ok().build();

        } catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
