package br.com.quintoandar.quintolog.services;

import br.com.quintoandar.quintolog.entity.LogError;
import br.com.quintoandar.quintolog.repository.LogRepository;
import br.com.quintoandar.quintolog.templates.entity.LogTemplate;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
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
        List<LogError> log = from(LogError.class).gimme(2, LogTemplate.VALID);
        List<LogError> returnLog = new ArrayList<>();

        when(repository.findAll()).thenReturn(log);
        returnLog = service.listAll();
        assertThat(returnLog).isEqualTo(log);
    }

    @Test
    public void shouldListLogsById() {
        LogError log = from(LogError.class).gimme(LogTemplate.VALID);

        Optional<LogError> returnLog;
        when(repository.findById(anyLong())).thenReturn(Optional.of(log));
        returnLog = service.listById(10L);
        assertThat(returnLog).isEqualTo(Optional.of(log));
    }

    @Test
    public void shouldDeleteLog() {
        doNothing().when(repository).deleteById(anyLong());
        service.delete(10L);
        verify(repository, times(1)).deleteById(10L);
    }

    @Test
    public void shouldSaveLog() {
        LogError log = from(LogError.class).gimme(LogTemplate.VALID);

        when(repository.save(Mockito.any())).thenReturn(log);
        service.save(log);
        verify(repository, times(1)).save(log);
    }
}
