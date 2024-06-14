package fatec.projeto.projeto_lp2.model;

import lombok.Data;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
@Data
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String filename;

    @Column(nullable = false)
    private String problemCode;

    @Column(nullable = false)
    private String lps;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL)
    private Set<TestCase> testCases;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL)
    private Set<Solution> solutions;
}
