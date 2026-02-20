package testspringapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import testspringapp.dto.CinemaDTO;
import testspringapp.mapper.CinemaMapper;
import testspringapp.model.Cinema;

public class CinemaMapperTest {

    @Test
    void checkCinemaMapper() {
        final CinemaMapper mapper = Mappers.getMapper(CinemaMapper.class);

        CinemaDTO cinemaDTO = new CinemaDTO();
        cinemaDTO.setName("KARO");
        cinemaDTO.setAddress("Lenina 1");

        Cinema cinema = mapper.cinemaDtoToCinema(cinemaDTO);

        Assertions.assertNotNull(cinema);
        Assertions.assertEquals(cinemaDTO.getAddress(), cinema.getAddress());
        Assertions.assertEquals(cinemaDTO.getName(), cinema.getName());
    }
}
