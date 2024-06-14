package fatec.projeto.projeto_lp2.repository;

import fatec.projeto.projeto_lp2.model.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
    Problem findByProblemCode(String problemCode);
}
