package Services;

import model.Path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathService {
    private Map<Long, Path> paths;

    public PathService() {
        this.paths = new HashMap<>();
    }

    // Método para agregar un nuevo camino
    public void addPath(Path path) {
        paths.put(path.getPathId(), path);
    }

    // Método para obtener un camino dado el id de la estación origen y destino
    public Path getPathBySourceAndDestination(Long sourceId, Long destinationId) {
        for (Path path : paths.values()) {
            if (path.getSourceId().equals(sourceId) && path.getDestinationId().equals(destinationId)) {
                return path;
            }
        }
        return null; // Retorna null si no se encuentra un camino con los ids dados
    }

    // Método para obtener todos los caminos
    public List<Path> getAllPaths() {
        return new ArrayList<>(paths.values());
    }

    // Método para eliminar un camino dado su id
    public void removePath(Long pathId) {
        paths.remove(pathId);
    }

    // Método para eliminar todos los caminos
    public void removeAllPaths() {
        paths.clear();
    }
}
