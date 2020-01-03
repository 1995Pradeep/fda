package fda.fda.model;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/food")
@Slf4j
@RequiredArgsConstructor
public class foodAPI {
    private final foodService foodService;

    @GetMapping
    public ResponseEntity<List<food>> findAll() {
        return ResponseEntity.ok(foodService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody food product) {
        return ResponseEntity.ok(foodService.save(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<food> findById(@PathVariable Long id) {
        Optional<food> stock = foodService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<food> update(@PathVariable Long id, @Valid @RequestBody food product) {
        if (!foodService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(foodService.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!foodService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        foodService.deleteById(id);

        return ResponseEntity.ok().build();
    }}
