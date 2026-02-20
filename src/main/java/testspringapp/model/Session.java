package testspringapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Session {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private LocalDateTime sessionTime;

    @ManyToMany(mappedBy = "session")
    private Set<Cinema> cinema = new HashSet<>();
}
