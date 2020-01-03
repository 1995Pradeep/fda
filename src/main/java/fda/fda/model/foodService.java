package fda.fda.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class foodService {

    private final foodRepository foodRepository;

    public List<food> findAll() {
        return foodRepository.findAll();
    }

    public Optional<food> findById(Long id) {
        return foodRepository.findById(id);
    }

    public food save(food stock) {
        return foodRepository.save(stock);
    }

    public void deleteById(Long id) {
        foodRepository.deleteById(id);
    }

}
