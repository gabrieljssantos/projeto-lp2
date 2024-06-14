package fatec.projeto.projeto_lp2.controller;

import fatec.projeto.projeto_lp2.model.Solution;
import fatec.projeto.projeto_lp2.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/solutions")
public class SolutionController {

    @Autowired
    private SolutionService solutionService;

    @PostMapping
    public ResponseEntity<?> createSolution(@RequestBody Solution solution) {
        Solution savedSolution = solutionService.saveSolution(solution);
        return new ResponseEntity<>(savedSolution, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Solution>> getAllSolutions() {
        List<Solution> solutions = solutionService.getAllSolutions();
        return new ResponseEntity<>(solutions, HttpStatus.OK);
    }

    @GetMapping("/problem/{problemCode}")
    public ResponseEntity<List<Solution>> getSolutionsByProblemCode(@PathVariable String problemCode) {
        List<Solution> solutions = solutionService.getSolutionsByProblemCode(problemCode);
        return new ResponseEntity<>(solutions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solution> getSolutionById(@PathVariable Long id) {
        Optional<Solution> solution = solutionService.getSolutionById(id);
        return solution.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSolution(@PathVariable Long id) {
        solutionService.deleteSolution(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
