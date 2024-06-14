package fatec.projeto.projeto_lp2.service;

import fatec.projeto.projeto_lp2.model.TestCase;
import fatec.projeto.projeto_lp2.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepository;

    public TestCase saveTestCase(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }

    public List<TestCase> getTestCasesByProblemCode(String problemCode) {
        return testCaseRepository.findByProblemCode(problemCode);
    }

    public List<TestCase> getAllTestCases() {
        return testCaseRepository.findAll();
    }

    public Optional<TestCase> getTestCaseById(Long id) {
        return testCaseRepository.findById(id);
    }

    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }
}
