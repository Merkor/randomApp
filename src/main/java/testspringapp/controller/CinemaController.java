package testspringapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import testspringapp.dto.CinemaDTO;
import testspringapp.service.CinemaService;

@RestController
@RequestMapping("/api/cinemas")
@RequiredArgsConstructor
@Validated
public class CinemaController {

    private final CinemaService cinemaService;

    @Operation(
            summary = "Get cinema by Id",
            description = "Get cinema by Id",
            tags = {"CinemaDTO"},
            parameters = {
                    @Parameter(
                            name = "id",
                            required = true,
                            description = "id of cinema",
                            schema = @Schema(type = "Long")
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<CinemaDTO> getCinemaById(@PathVariable("id") @Min(1) Long id) {
        final CinemaDTO cinemaDTO = cinemaService.getCinemaById(id);
        return ResponseEntity.ok(cinemaDTO);
    }

    @PostMapping
    public ResponseEntity<CinemaDTO> addCinema(@Valid @RequestBody CinemaDTO cinemaDTO) {
        final CinemaDTO saved = cinemaService.addCinema(cinemaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CinemaDTO> patchCinema(@PathVariable("id") @Min(1) Long id,
                                                 @RequestBody CinemaDTO cinemaDTO) {
        final CinemaDTO patched = cinemaService.patchCinema(cinemaDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body(patched);
    }
}
