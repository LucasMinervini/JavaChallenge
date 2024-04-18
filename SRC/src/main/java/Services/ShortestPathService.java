package Services;

import model.ShortestPathResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ShortestPathService {

    private final PathService pathRepository;

    @Autowired
    public ShortestPathService(PathService pathRepository) {
        this.pathRepository = pathRepository;
    }

    public ShortestPathResponse getShortestPath(Long sourceId, Long destinationId) {
        // Aquí implementa la lógica para calcular el camino más corto
        // Puedes usar algoritmos como Dijkstra o Floyd-Warshall

        // Ejemplo de implementación simple
        List<Long> shortestPath = Arrays.asList(sourceId, 123L, destinationId); // Dummy data
        double cost = 100.0; // Dummy cost

        return new ShortestPathResponse(shortestPath, cost);
    }
}

