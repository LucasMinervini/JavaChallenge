package Controller;

import Services.PathService;
import model.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PathController {

    private final PathService service;

    public PathController(PathService service) {
        this.service = service;
    }

    private final Map<String, Double> pathCosts = new HashMap<>();

    @PutMapping
    public ResponseEntity<String> createPath(@RequestBody Path path) {
        // Suponiendo que pathId es único y no se repetirá.
        String key = path.getSourceId() + "-" + path.getDestinationId();
        pathCosts.put(key, path.getCost());
        return new ResponseEntity<>("Camino creado con éxito", HttpStatus.CREATED);
    }

    @GetMapping("/{sourceId}/{destinationId}")
    public ResponseEntity<Double> getPathCost(@PathVariable Long sourceId, @PathVariable Long destinationId) {
        String key = sourceId + "-" + destinationId;
        if (pathCosts.containsKey(key)) {
            double cost = pathCosts.get(key);
            return ResponseEntity.ok(cost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
