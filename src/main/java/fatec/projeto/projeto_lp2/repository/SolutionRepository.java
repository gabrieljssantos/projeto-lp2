package fatec.projeto.projeto_lp2.repository;

import fatec.projeto.projeto_lp2.model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Long> {
    List<Solution> findByProblemCode(String problemCode);
}
