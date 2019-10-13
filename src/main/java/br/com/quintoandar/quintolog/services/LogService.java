package br.com.quintoandar.quintolog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintoandar.quintolog.entity.Log;
import br.com.quintoandar.quintolog.interfaces.InterfaceServices;
import br.com.quintoandar.quintolog.repository.LogRepository;

@Service
public class LogService implements InterfaceServices<Object> {
	@Autowired
	private LogRepository repositorio;
	
	@Override
	public List<Log> listarTodos() {
		return repositorio.findAll();
	}
	
	@Override
	public Optional<Log> listarPorId(Long id) {
		return repositorio.findById(id);
	}
	
	@Override
	public void deletar(Long id) {
		repositorio.deleteById(id);
	}

	@Override
	public void salvar(Object object) {
		repositorio.save((Log) object);
	}
}
