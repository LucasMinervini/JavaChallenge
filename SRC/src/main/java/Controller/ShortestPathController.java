package Controller;

import Services.ShortestPathService;
import model.ShortestPathResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shortest-path")
public class ShortestPathController {

    private final ShortestPathService shortestPathService;

    @Autowired
    public ShortestPathController(ShortestPathService shortestPathService) {
        this.shortestPathService = shortestPathService;
    }

    @GetMapping
    public ResponseEntity<ShortestPathResponse> getShortestPath(@RequestParam Long sourceId,
                                                                @RequestParam Long destinationId) {
        ShortestPathResponse shortestPath = shortestPathService.getShortestPath(sourceId, destinationId);
        return ResponseEntity.ok(shortestPath);
    }
}

