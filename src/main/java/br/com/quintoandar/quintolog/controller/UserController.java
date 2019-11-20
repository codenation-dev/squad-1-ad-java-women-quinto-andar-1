package br.com.quintoandar.quintolog.controller;

import br.com.quintoandar.quintolog.entity.LogUser;
import br.com.quintoandar.quintolog.entity.enums.SecurityQuestion;
import br.com.quintoandar.quintolog.services.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    Logger logger = Logger.getLogger(getClass());

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<LogUser> save(@RequestBody LogUser logUser) {
        try {
            Optional<LogUser> user = userService.listByEmail(logUser.getEmail());
            if (user.isPresent()) return ResponseEntity.status(500).build();

            LogUser newUser = (LogUser) logUser;
            newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
            userService.save(newUser);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                    "/{id}").buildAndExpand(logUser.getId()).toUri();

            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            logger.error("Dados inválidos: " + e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public Object list() {
        return userService.listAll();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateData(@PathVariable Long id, @RequestBody LogUser logUser){
        Optional<LogUser> user = userService.listById(id);
        if (!user.isPresent()) return ResponseEntity.notFound().build();

        LogUser updateUser = user.get();

        updateUser.setEmail(logUser.getEmail());
        updateUser.setName(logUser.getName());
        updateUser.setSecurityQuestion(logUser.getSecurityQuestion());
        updateUser.setSecurityAnswer(logUser.getSecurityAnswer());
        userService.save(updateUser);
        return ResponseEntity.ok(user.get());
    }

    @PutMapping(value = "changePassword/{id}")
    public ResponseEntity<?> changePassword(@PathVariable Long id, @RequestBody Map<String, String> data){
        try {
            Optional<LogUser> user = userService.listById(id);
            if (!user.isPresent()) return ResponseEntity.notFound().build();
            LogUser updateUser = user.get();

            final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if(!passwordEncoder.matches(data.get("oldPassword"), updateUser.getPassword())) {
                return new ResponseEntity<String>("Senha inválida", HttpStatus.UNAUTHORIZED);
            }

            updateUser.setPassword(new BCryptPasswordEncoder().encode(data.get("newPassword")));
            userService.save(updateUser);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Dados inválidos: " + e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "recoverPassword")
    public ResponseEntity<?> recoverPassword(@RequestBody Map<String, String> data){
        try {
            Optional<LogUser> user = userService.listByEmail(data.get("email"));
            if (!user.isPresent()) return ResponseEntity.notFound().build();

            LogUser updateUser = user.get();
            SecurityQuestion securityQuestion = SecurityQuestion.getSecurityQuestion(Integer.parseInt(data.get("security_question")));
            if (!updateUser.getName().equals(data.get("name")) || updateUser.getSecurityQuestion() != securityQuestion || !updateUser.getSecurityAnswer().equals(data.get("security_answer")) ){
                return new ResponseEntity<String>("Dados inválidos", HttpStatus.UNAUTHORIZED);
            }

            updateUser.setPassword(new BCryptPasswordEncoder().encode(data.get("password")));
            userService.save(updateUser);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Dados inválidos: " + e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "getData")
    public ResponseEntity<LogUser> listByEmail(@RequestBody Map<String, String> data) {
        Optional<LogUser> user = userService.listByEmail(data.get("email"));
        if (!user.isPresent()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(user.get());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LogUser> listById(@PathVariable Long id) {
        Optional<LogUser> user = userService.listById(id);
        return user.isPresent() ? ResponseEntity.ok(user.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<LogUser> user = userService.listById(id);
        if (!user.isPresent()) return ResponseEntity.notFound().build();
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
