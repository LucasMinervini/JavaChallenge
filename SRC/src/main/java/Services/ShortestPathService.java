package Services;

import model.ShortestPathResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShortestPathService {

    private final PathService pathRepository;

    @Autowired
    public ShortestPathService(PathService pathRepository) {
        this.pathRepository = pathRepository;
    }

    private final Map<Long, Map<Long, Double>> graph = new HashMap<>();

    public ShortestPathService() {
        // Aquí puedes inicializar tu grafo con los datos de los caminos y sus costos
        // Por ejemplo:
        addEdge(1L, 2L, 50.0);
        addEdge(1L, 3L, 100.0);
        addEdge(2L, 3L, 20.0);
        pathRepository = null;
    }

    private void addEdge(Long sourceId, Long destinationId, Double cost) {
        if (!graph.containsKey(sourceId)) {
            graph.put(sourceId, new HashMap<>());
        }
        graph.get(sourceId).put(destinationId, cost);

        if (!graph.containsKey(destinationId)) {
            graph.put(destinationId, new HashMap<>());
        }
        graph.get(destinationId).put(sourceId, cost);
    }
    public ShortestPathResponse getShortestPath(Long sourceId, Long destinationId) {
        // Aquí implementa la lógica para calcular el camino más corto
        Map<Long, Double> distances = new HashMap<>();
        Map<Long, Long> previous = new HashMap<>();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        for (Long node : graph.keySet()) {
            if (node.equals(sourceId)) {
                distances.put(node, 0.0);
            } else {
                distances.put(node, Double.POSITIVE_INFINITY);
            }
            priorityQueue.add(node);
        }

        while (!priorityQueue.isEmpty()) {
            Long currentNode = priorityQueue.poll();
            if (currentNode.equals(destinationId)) {
                break;
            }
            for (Long neighbor : graph.get(currentNode).keySet()) {
                double newDistance = distances.get(currentNode) + graph.get(currentNode).get(neighbor);
                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    previous.put(neighbor, currentNode);
                    priorityQueue.add(neighbor);
                }
            }
        }

        List<Long> path = new ArrayList<>();
        Long current = destinationId;
        while (previous.containsKey(current)) {
            path.add(current);
            current = previous.get(current);
        }
        path.add(sourceId);
        Collections.reverse(path);

        //double cost = distances.get(destinationId);
        double cost = 100.0; // Dummy cost
        return new ShortestPathResponse(path, cost);
        // Puedes usar algoritmos como Dijkstra o Floyd-Warshall

    }
}

