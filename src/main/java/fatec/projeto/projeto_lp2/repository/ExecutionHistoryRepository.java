package fatec.projeto.projeto_lp2.repository;

import fatec.projeto.projeto_lp2.model.ExecutionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExecutionHistoryRepository extends JpaRepository<ExecutionHistory, Long> {
    List<ExecutionHistory> findByAuthor(String author);
    List<ExecutionHistory> findByProblemCode(String problemCode);
}
