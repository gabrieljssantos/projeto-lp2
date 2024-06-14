package fatec.projeto.projeto_lp2.repository;

import fatec.projeto.projeto_lp2.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findByProblemCode(String problemCode);
}
