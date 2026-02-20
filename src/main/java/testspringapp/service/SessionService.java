package testspringapp.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import testspringapp.dto.PosterDTO;
import testspringapp.model.Cinema;
import testspringapp.model.Session;
import testspringapp.repository.CinemaRepository;
import testspringapp.repository.SessionRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SessionService {

    private final SessionRepository sessionRepository;
    private final CinemaRepository cinemaRepository;

    public List<PosterDTO> getSessionByTime(LocalDateTime time) {
        final List<Session> sessionList =
                sessionRepository.findSessionBySessionTimeBeforeAndSessionTimeAfter(time, LocalDateTime.now());

        List<PosterDTO> posterDTOS = new ArrayList<>();

        sessionList.forEach(session -> {
            final List<Cinema> cinemaBySession = cinemaRepository.findCinemaBySession(session);

            cinemaBySession.forEach(cinema -> {
                final PosterDTO build = PosterDTO.builder()
                        .cinemaAddress(cinema.getAddress())
                        .sessionName(session.getName())
                        .time(session.getSessionTime())
                        .build();
                posterDTOS.add(build);
            });
        });
        return posterDTOS;
    }
}
