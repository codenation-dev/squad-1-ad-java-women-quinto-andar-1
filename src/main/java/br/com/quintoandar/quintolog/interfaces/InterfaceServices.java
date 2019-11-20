package br.com.quintoandar.quintolog.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface InterfaceServices<T> {

    public void save(T object);
    public List<?> listAll();
    public Optional<?> listById(Long id);
    public void delete(Long id);

}
