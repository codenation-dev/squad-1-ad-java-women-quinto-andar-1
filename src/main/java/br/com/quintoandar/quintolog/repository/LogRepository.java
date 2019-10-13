package br.com.quintoandar.quintolog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.quintoandar.quintolog.entity.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

}
