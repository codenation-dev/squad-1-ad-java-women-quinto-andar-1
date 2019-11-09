package br.com.quintoandar.quintolog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.quintoandar.quintolog.entity.LogUser;
import br.com.quintoandar.quintolog.interfaces.InterfaceServices;
import br.com.quintoandar.quintolog.repository.LogUserRepository;

@Service
public class UserService implements InterfaceServices<Object> {

    @Autowired
    private LogUserRepository logUserRepository;

    public Optional<LogUser> listByEmail(String email){
        return logUserRepository.findByEmail(email);
    }

    @Override
    public void save(Object object) {
    	
    	LogUser log =  (LogUser) object;
    	log.setPassword(new BCryptPasswordEncoder().encode(log.getPassword()));
    	
        logUserRepository.save(log);
    }

    @Override
    public List<LogUser> listAll() {
       return  logUserRepository.findAll();
    }

    @Override
    public Optional<LogUser> listById(Long id) {
        return logUserRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        logUserRepository.deleteById(id);
    }
}
