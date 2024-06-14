package fatec.projeto.projeto_lp2.controller;

import fatec.projeto.projeto_lp2.model.ExecutionHistory;
import fatec.projeto.projeto_lp2.service.ExecutionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/executionhistory")
public class ExecutionHistoryController {

    @Autowired
    private ExecutionHistoryService executionHistoryService;

    @PostMapping
    public ResponseEntity<?> createExecutionHistory(@RequestBody ExecutionHistory executionHistory) {
        ExecutionHistory savedExecutionHistory = executionHistoryService.saveExecutionHistory(executionHistory);
        return new ResponseEntity<>(savedExecutionHistory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ExecutionHistory>> getAllExecutionHistories() {
        List<ExecutionHistory> executionHistories = executionHistoryService.getAllExecutionHistories();
        return new ResponseEntity<>(executionHistories, HttpStatus.OK);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<ExecutionHistory>> getExecutionHistoriesByAuthor(@PathVariable String author) {
        List<ExecutionHistory> executionHistories = executionHistoryService.getExecutionHistoriesByAuthor(author);
        return new ResponseEntity<>(executionHistories, HttpStatus.OK);
    }

    @GetMapping("/problem/{problemCode}")
    public ResponseEntity<List<ExecutionHistory>> getExecutionHistoriesByProblemCode(@PathVariable String problemCode) {
        List<ExecutionHistory> executionHistories = executionHistoryService.getExecutionHistoriesByProblemCode(problemCode);
        return new ResponseEntity<>(executionHistories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExecutionHistory> getExecutionHistoryById(@PathVariable Long id) {
        Optional<ExecutionHistory> executionHistory = executionHistoryService.getExecutionHistoryById(id);
        return executionHistory.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExecutionHistory(@PathVariable Long id) {
        executionHistoryService.deleteExecutionHistory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
