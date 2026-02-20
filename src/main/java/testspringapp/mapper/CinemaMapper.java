package testspringapp.mapper;

import org.mapstruct.*;
import testspringapp.dto.CinemaDTO;
import testspringapp.model.Cinema;

@Mapper(componentModel = "spring")
public interface CinemaMapper {

    CinemaDTO cinemaToCinemaDto(Cinema cinema);

    Cinema cinemaDtoToCinema(CinemaDTO cinemaDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void patch(@MappingTarget Cinema cinema, CinemaDTO dto);
}
