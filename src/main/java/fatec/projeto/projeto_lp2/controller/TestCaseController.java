package fatec.projeto.projeto_lp2.controller;

import fatec.projeto.projeto_lp2.model.TestCase;
import fatec.projeto.projeto_lp2.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/testcases")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    @PostMapping
    public ResponseEntity<?> createTestCase(@RequestBody TestCase testCase) {
        TestCase savedTestCase = testCaseService.saveTestCase(testCase);
        return new ResponseEntity<>(savedTestCase, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestCase>> getAllTestCases() {
        List<TestCase> testCases = testCaseService.getAllTestCases();
        return new ResponseEntity<>(testCases, HttpStatus.OK);
    }

    @GetMapping("/problem/{problemCode}")
    public ResponseEntity<List<TestCase>> getTestCasesByProblemCode(@PathVariable String problemCode) {
        List<TestCase> testCases = testCaseService.getTestCasesByProblemCode(problemCode);
        return new ResponseEntity<>(testCases, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getTestCaseById(@PathVariable Long id) {
        Optional<TestCase> testCase = testCaseService.getTestCaseById(id);
        return testCase.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
