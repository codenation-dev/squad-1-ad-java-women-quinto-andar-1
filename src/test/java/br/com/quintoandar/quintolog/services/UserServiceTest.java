package br.com.quintoandar.quintolog.services;

import br.com.quintoandar.quintolog.entity.LogUser;
import br.com.quintoandar.quintolog.repository.LogUserRepository;
import br.com.quintoandar.quintolog.templates.entity.UserTemplate;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static br.com.six2six.fixturefactory.Fixture.from;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService service;
    @Mock
    private LogUserRepository repository;

    @Before
    public void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.quintoandar.quintolog.templates");
    }

    @Test
    public void shouldListByEmail() {
        LogUser user = from(LogUser.class).gimme(UserTemplate.VALID);

        when(repository.findByEmail("")).thenReturn(Optional.of(user));
        Optional<LogUser> result = service.listByEmail("");
        assertThat(result).isEqualTo(Optional.of(user));
    }

    @Test
    public void shouldSaveUser() {
        LogUser user = from(LogUser.class).gimme(UserTemplate.VALID);

        when(repository.save(Mockito.any())).thenReturn(user);
        service.save(user);
        verify(repository, times(1)).save(user);
    }

    @Test
    public void shouldListAllUsers() {
        List<LogUser> userList = from(LogUser.class).gimme(2, UserTemplate.VALID);

        when(repository.findAll()).thenReturn(userList);
        List<LogUser> returnList = service.listAll();
        assertThat(returnList).isEqualTo(userList);
    }

    @Test
    public void shouldFindById() {
        LogUser user = from(LogUser.class).gimme(UserTemplate.VALID);

        when(repository.findById(1L)).thenReturn(Optional.of(user));
        Optional<LogUser> result = service.listById(1L);
        assertThat(result).isEqualTo(Optional.of(user));
    }

    @Test
    public void shouldDeleteUser() {
        doNothing().when(repository).deleteById(Mockito.anyLong());
        service.delete(10L);
        verify(repository, times(1)).deleteById(10L);
    }
}
