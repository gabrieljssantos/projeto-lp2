package fatec.projeto.projeto_lp2.model;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
public class ExecutionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String filename;

    @ManyToOne
    @JoinColumn(name = "problem_code", nullable = false)
    private Problem problem;

    @Column(nullable = false)
    private String sourceCode;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime executionTime;
}
