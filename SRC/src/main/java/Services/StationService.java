package Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StationService {
    private Map<Long, Station> stations;

    public StationService() {
        this.stations = new HashMap<>();
    }

    // Método para agregar una nueva estación
    public void addStation(Station station) {
        stations.put(station.getStationId(), station);
    }

    // Método para obtener una estación dado su id
    public Station getStationById(Long stationId) {
        return stations.get(stationId);
    }

    // Método para obtener todas las estaciones
    public List<Station> getAllStations() {
        return new ArrayList<>(stations.values());
    }

    // Método para eliminar una estación dado su id
    public boolean removeStation(Long stationId) {
        stations.remove(stationId);
        return false;
    }

    // Método para eliminar todas las estaciones
    public void removeAllStations() {
        stations.clear();
    }
}
