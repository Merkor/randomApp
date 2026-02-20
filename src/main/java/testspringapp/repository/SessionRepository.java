package testspringapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testspringapp.model.Session;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    List<Session> findSessionBySessionTimeBeforeAndSessionTimeAfter(LocalDateTime timeBefore, LocalDateTime timeAfter);
}
