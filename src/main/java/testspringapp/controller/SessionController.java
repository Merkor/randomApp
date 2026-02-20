package testspringapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import testspringapp.dto.PosterDTO;
import testspringapp.service.SessionService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/session")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @GetMapping("/by-time")
    public List<PosterDTO> getSessionByTime(@RequestParam LocalDateTime time) {
        return sessionService.getSessionByTime(time);
    }
}
