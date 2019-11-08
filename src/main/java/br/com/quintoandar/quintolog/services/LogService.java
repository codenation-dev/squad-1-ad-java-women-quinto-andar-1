package br.com.quintoandar.quintolog.services;

import br.com.quintoandar.quintolog.entity.LogError;
import br.com.quintoandar.quintolog.interfaces.InterfaceServices;
import br.com.quintoandar.quintolog.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogService implements InterfaceServices<Object> {

    @Autowired
    private LogRepository logRepository;


    public List<LogError> listAll() {
        return logRepository.findAll();
    }

    @Override
    public Optional<LogError> listById(Long id) {
        return logRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        logRepository.deleteById(id);
    }

    @Override
    public void save(Object object) {
        logRepository.save((LogError) object);
    }
}
