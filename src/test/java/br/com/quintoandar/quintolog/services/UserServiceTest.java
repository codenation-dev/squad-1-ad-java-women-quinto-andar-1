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
import static org.mockito.Mockito.*;

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
        LogUser user = from(LogUser.class).gimme(UserTemplate.VALIDO);

        when(repository.findByEmail("")).thenReturn(Optional.of(user));

        Optional<LogUser> retorno = service.listByEmail("");

        assertThat(retorno).isEqualTo(Optional.of(user));
    }

    @Test
    public void shouldSaveUser() {
        LogUser user = from(LogUser.class).gimme(UserTemplate.VALIDO);

        when(repository.save(Mockito.any())).thenReturn(user);

        service.save(user);

        verify(repository, times(1)).save(user);
    }

    @Test
    public void shouldListAllUsers() {
        List<LogUser> userList = from(LogUser.class).gimme(2, UserTemplate.VALIDO);

        when(repository.findAll()).thenReturn(userList);

        List<LogUser> retornoList = service.listAll();

        assertThat(retornoList).isEqualTo(userList);
    }

    @Test
    public void shouldFindById() {
        LogUser user = from(LogUser.class).gimme(UserTemplate.VALIDO);

        when(repository.findById(1L)).thenReturn(Optional.of(user));

        Optional<LogUser> retorno = service.listById(1L);

        assertThat(retorno).isEqualTo(Optional.of(user));
    }

    @Test
    public void shouldDeleteUser() {
        doNothing().when(repository).deleteById(Mockito.anyLong());

        service.delete(10L);

        verify(repository, times(1)).deleteById(10L);
    }

}
