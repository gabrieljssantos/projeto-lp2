package fatec.projeto.projeto_lp2.service;

import fatec.projeto.projeto_lp2.model.Problem;
import fatec.projeto.projeto_lp2.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    public Problem saveProblem(Problem problem) {
        // Verifica se o problema já existe
        if (problemRepository.findByProblemCode(problem.getProblemCode()) != null) {
            throw new IllegalArgumentException("Problema com o mesmo código já existe.");
        }
        return problemRepository.save(problem);
    }

    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }

    public Optional<Problem> getProblemById(Long id) {
        return problemRepository.findById(id);
    }

    public void deleteProblem(Long id) {
        problemRepository.deleteById(id);
    }
}
