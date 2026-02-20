package testspringapp.configuration;

import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import testspringapp.mapper.CinemaMapper;
import testspringapp.repository.CinemaRepository;

@Configuration
public class CinemaMocksConfig {

    @Bean
    public CinemaRepository getCinemaRepositoryMock() {
        return Mockito.mock(CinemaRepository.class);
    }

    @Bean
    public CinemaMapper cinemaMapper() {
        return Mappers.getMapper(CinemaMapper.class);
    }
}
