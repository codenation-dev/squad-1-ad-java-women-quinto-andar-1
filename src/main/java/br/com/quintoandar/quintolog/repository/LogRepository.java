package br.com.quintoandar.quintolog.repository;

import br.com.quintoandar.quintolog.entity.LogError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogError, Long> {

}
