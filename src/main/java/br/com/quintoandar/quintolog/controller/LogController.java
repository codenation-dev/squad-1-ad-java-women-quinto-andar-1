package br.com.quintoandar.quintolog.controller;

import java.net.URI;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.quintoandar.quintolog.entity.Log;
import br.com.quintoandar.quintolog.services.LogService;

@RestController
@RequestMapping("/v1/logs")
public class LogController {
	
	Logger logger = Logger.getLogger(getClass());

	@Autowired
	private LogService logService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Log log) {
		try {
			logService.save(log);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
					"/{id}").buildAndExpand(log.getId()).toUri();
			
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			logger.error("Dados inválidos: " + e);
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping
	public Object list(Pageable pageable) {
		try {
			return logService.listAll(pageable);
		} catch (Exception e) {
			logger.error("Dados inválidos: " + e);
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Log> listById(@PathVariable Long id) {
		Optional<Log> log = logService.listById(id);
		return log.isPresent() ? ResponseEntity.ok(log.get()) : ResponseEntity.notFound().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Optional<Log> log = logService.listById(id);
		if (!log.isPresent()) return ResponseEntity.notFound().build();
		logService.delete(id);
		return ResponseEntity.ok().build();
	}
}
