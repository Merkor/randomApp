package testspringapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import testspringapp.configuration.CinemaMocksConfig;
import testspringapp.dto.CinemaDTO;
import testspringapp.mapper.CinemaMapper;
import testspringapp.model.Cinema;
import testspringapp.repository.CinemaRepository;
import testspringapp.service.CinemaService;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CinemaMocksConfig.class})
public class TestCinemaServiceWithCustomSpringContext {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private CinemaMapper cinemaMapper;

    @Test
    public void testPatchCinema() {
        Cinema originalCinema = new Cinema();
        originalCinema.setId(1L);
        originalCinema.setAddress("ADDRESS 1");
        originalCinema.setName("NAME 1");

        CinemaDTO patchDto = new CinemaDTO();
        patchDto.setAddress("ADDRESS 2");

        Mockito.when(cinemaRepository.findById(1L))
                .thenReturn(Optional.of(originalCinema));

        Mockito.when(cinemaRepository.save(Mockito.any(Cinema.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        CinemaService cinemaService = new CinemaService(cinemaRepository, cinemaMapper);

        CinemaDTO result = cinemaService.patchCinema(patchDto, 1L);

        Assertions.assertEquals("ADDRESS 2", result.getAddress());
        Assertions.assertEquals("NAME 1", result.getName());

        Mockito.verify(cinemaRepository).findById(1L);
        Mockito.verify(cinemaRepository).save(originalCinema);
    }
}
