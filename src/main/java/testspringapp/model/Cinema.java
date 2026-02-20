package testspringapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cinema {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;

    @ManyToMany (cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "cinema_session",
            joinColumns = @JoinColumn(name = "cinema_id"),
            inverseJoinColumns = @JoinColumn(name = "session_id")
    )
    private List<Session> session;
}
