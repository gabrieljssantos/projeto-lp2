package fatec.projeto.projeto_lp2.service;

import fatec.projeto.projeto_lp2.model.Solution;
import fatec.projeto.projeto_lp2.repository.SolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolutionService {

    @Autowired
    private SolutionRepository solutionRepository;

    public Solution saveSolution(Solution solution) {
        return solutionRepository.save(solution);
    }

    public List<Solution> getSolutionsByProblemCode(String problemCode) {
        return solutionRepository.findByProblemCode(problemCode);
    }

    public List<Solution> getAllSolutions() {
        return solutionRepository.findAll();
    }

    public Optional<Solution> getSolutionById(Long id) {
        return solutionRepository.findById(id);
    }

    public void deleteSolution(Long id) {
        solutionRepository.deleteById(id);
    }
}
