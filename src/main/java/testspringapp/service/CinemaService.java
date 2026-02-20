package testspringapp.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import testspringapp.dto.CinemaDTO;
import testspringapp.mapper.CinemaMapper;
import testspringapp.model.Cinema;
import testspringapp.repository.CinemaRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    private final CinemaMapper cinemaMapper;

    public CinemaDTO getCinemaById(Long id) {
        final Cinema cinema = cinemaRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cinema not found with id = " + id));

        return cinemaMapper.cinemaToCinemaDto(cinema);
    }

    public CinemaDTO addCinema(CinemaDTO cinemaDTO) {
        final Cinema saved = cinemaRepository.save(cinemaMapper.cinemaDtoToCinema(cinemaDTO));
        return cinemaMapper.cinemaToCinemaDto(saved);
    }

    public CinemaDTO patchCinema(CinemaDTO cinemaDTO, Long id) {
        final Cinema cinema = cinemaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cinema not found with id = " + id));

        cinemaMapper.patch(cinema, cinemaDTO);

        Cinema saved = cinemaRepository.save(cinema);

        return cinemaMapper.cinemaToCinemaDto(saved);
    }
}
