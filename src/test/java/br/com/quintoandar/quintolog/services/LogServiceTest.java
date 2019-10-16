package br.com.quintoandar.quintolog.services;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.quintoandar.quintolog.entity.Log;
import br.com.quintoandar.quintolog.repository.LogRepository;
import br.com.quintoandar.quintolog.templates.entity.LogTemplate;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@RunWith(SpringJUnit4ClassRunner.class)
public class LogServiceTest {

	@InjectMocks
	private LogService service;

	@Mock
	private LogRepository repository;

	@Before
	public void setUp() {
		FixtureFactoryLoader.loadTemplates("br.com.quintoandar.quintolog.templates");
	}

	@Test
	public void shouldListAllLogs() {
		List<Log> log = from(Log.class).gimme(2, LogTemplate.VALIDO);
		List<Log> retornoLog = new ArrayList<>();
		
		when(repository.findAll()).thenReturn(log);
		
		retornoLog = service.listAll();
		
		assertThat(retornoLog).isEqualTo(log);
	}
	
	@Test
	public void shouldListLogsById() {
		Log log = from(Log.class).gimme(LogTemplate.VALIDO);
		Optional<Log> retornoLog;
		
		when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(log));
		
		retornoLog = service.listById(10L);
		
		assertThat(retornoLog).isEqualTo(Optional.of(log));
	}
	
	@Test
	public void shouldDeleteLog() {
		doNothing().when(repository).deleteById(Mockito.anyLong());
		
		service.delete(10L);
		
		verify(repository, times(1)).deleteById(10L);
	}
	
	@Test
	public void shouldSaveLog() {
		Log log = from(Log.class).gimme(LogTemplate.VALIDO);
		when(repository.save(Mockito.any())).thenReturn(log);
		
		service.save(log);
		
		verify(repository, times(1)).save(log);
	}
}
