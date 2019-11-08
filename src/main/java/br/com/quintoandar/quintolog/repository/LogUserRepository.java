package br.com.quintoandar.quintolog.repository;

import br.com.quintoandar.quintolog.entity.LogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogUserRepository extends JpaRepository<LogUser, Long> {

    Optional<LogUser> findByEmail(String email);
}
