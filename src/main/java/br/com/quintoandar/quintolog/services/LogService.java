package br.com.quintoandar.quintolog.services;

import br.com.quintoandar.quintolog.entity.Log;
import br.com.quintoandar.quintolog.interfaces.InterfaceServices;
import br.com.quintoandar.quintolog.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogService implements InterfaceServices<Object> {

    @Autowired
    private LogRepository logRepository;

    @Override
    public Page<?> listAll(Pageable pageable) {
        return logRepository.findAll(pageable);
    }

    @Override
    public Optional<Log> listById(Long id) {
        return logRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        logRepository.deleteById(id);
    }

    @Override
    public void save(Object object) {
        logRepository.save((Log) object);
    }
}
