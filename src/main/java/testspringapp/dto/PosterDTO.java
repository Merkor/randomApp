package testspringapp.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PosterDTO {
    private String cinemaAddress;
    private String sessionName;
    private LocalDateTime time;
}
