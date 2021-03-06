package br.com.quintoandar.quintolog.services;

import br.com.quintoandar.quintolog.entity.LogUser;
import br.com.quintoandar.quintolog.repository.LogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private LogUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<LogUser> user = repository.findByEmail(username);

        if (user.isPresent()) {
            return user.get();
        }

        throw new UsernameNotFoundException("User not found, please check your details.");
    }
}
