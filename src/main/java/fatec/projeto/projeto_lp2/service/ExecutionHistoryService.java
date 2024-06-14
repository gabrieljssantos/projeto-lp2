package fatec.projeto.projeto_lp2.service;

import fatec.projeto.projeto_lp2.model.ExecutionHistory;
import fatec.projeto.projeto_lp2.repository.ExecutionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExecutionHistoryService {

    @Autowired
    private ExecutionHistoryRepository executionHistoryRepository;

    public ExecutionHistory saveExecutionHistory(ExecutionHistory executionHistory) {
        return executionHistoryRepository.save(executionHistory);
    }

    public List<ExecutionHistory> getExecutionHistoriesByAuthor(String author) {
        return executionHistoryRepository.findByAuthor(author);
    }

    public List<ExecutionHistory> getExecutionHistoriesByProblemCode(String problemCode) {
        return executionHistoryRepository.findByProblemCode(problemCode);
    }

    public List<ExecutionHistory> getAllExecutionHistories() {
        return executionHistoryRepository.findAll();
    }

    public Optional<ExecutionHistory> getExecutionHistoryById(Long id) {
        return executionHistoryRepository.findById(id);
    }

    public void deleteExecutionHistory(Long id) {
        executionHistoryRepository.deleteById(id);
    }
}
