package br.com.quintoandar.quintolog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintoandar.quintolog.entity.Log;
import br.com.quintoandar.quintolog.services.LogService;

@RestController
public class LogController {

	@Autowired
	private LogService servico;

	@PostMapping(value = "/add/log")
	public ResponseEntity<?> salvar(@RequestBody Log log) {
		try {
			servico.salvar(log);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping(value="/list/log")
	public Object listar() {
		try {
			return servico.listarTodos();
		} catch (Exception e) {
			System.out.println("" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/list/log/{id}")
	public Object listarId(Long id) {
		try {
			return servico.listarPorId(id);
		} catch (Exception e) {
			System.out.println("" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value="/delete/log/{id}")
	public ResponseEntity<?> deletar(Long id) {
		try {
			servico.deletar(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
