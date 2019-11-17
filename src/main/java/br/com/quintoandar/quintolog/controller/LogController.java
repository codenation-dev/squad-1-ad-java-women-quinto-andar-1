package br.com.quintoandar.quintolog.controller;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

import br.com.quintoandar.quintolog.entity.LogError;
import br.com.quintoandar.quintolog.entity.enums.Status;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.quintoandar.quintolog.services.LogService;

@RestController
@RequestMapping("/v1/logs")
public class LogController {
	
	Logger logger = Logger.getLogger(getClass());

	@Autowired
	private LogService logService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody LogError logError) {
		try {
			logService.save(logError);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
					"/{id}").buildAndExpand(logError.getId()).toUri();
			
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			logger.error("Dados inválidos: " + e);
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping
	public Object list() {
		return logService.listAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<LogError> listById(@PathVariable Long id) {
		Optional<LogError> log = logService.listById(id);
		return log.isPresent() ? ResponseEntity.ok(log.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Map<String, String> data) {
		Optional<LogError> log = logService.listById(id);
		if (!log.isPresent()) return ResponseEntity.notFound().build();

		LogError update = log.get();
		update.setStatus(Status.getStatus(data.get("status")));
		logService.save(update);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Optional<LogError> log = logService.listById(id);
		if (!log.isPresent()) return ResponseEntity.notFound().build();
		logService.delete(id);
		return ResponseEntity.ok().build();
	}
}
