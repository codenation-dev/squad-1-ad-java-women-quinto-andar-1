package br.com.quintoandar.quintolog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintoandar.quintolog.entity.Log;
import br.com.quintoandar.quintolog.services.LogService;

@RestController
@RequestMapping("/v1/logs")
public class LogController {

	@Autowired
	private LogService logService;

	@PostMapping(value = "/add/log")
	public ResponseEntity<?> save(@RequestBody Log log) {
		try {
			logService.save(log);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping(value = "/list/log")
	public Object list(Pageable pageable) {
		try {
			return logService.listAll(pageable);
		} catch (Exception e) {
			System.out.println("" + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/list/log/{id}")
	public ResponseEntity<Log> listById(@PathVariable Long id) {
		Optional<Log> log = logService.listById(id);
		return log.isPresent() ? ResponseEntity.ok(log.get()) : ResponseEntity.notFound().build();
	}

	@DeleteMapping(value = "/delete/log/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Optional<Log> log = logService.listById(id);
		if (!log.isPresent()) return ResponseEntity.notFound().build();
		logService.delete(id);
		return ResponseEntity.ok().build();
	}
}
