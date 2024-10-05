package datasource.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "response")
public class ResponseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private LocalDate uploadDate;

    @ManyToOne
    @JoinColumn(name = "id_sugestion", nullable = false, unique = true)
    private SugestionEntity sugestion;
}
