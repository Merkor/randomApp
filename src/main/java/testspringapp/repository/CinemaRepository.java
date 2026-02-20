package testspringapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testspringapp.model.Cinema;
import testspringapp.model.Session;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    List<Cinema> findCinemaBySession(Session session);
}
