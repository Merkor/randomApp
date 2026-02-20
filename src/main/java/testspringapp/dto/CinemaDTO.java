package testspringapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CinemaDTO {
    private Long id;

    @NotEmpty
    private String name;

    @NotNull
    private String address;
}
