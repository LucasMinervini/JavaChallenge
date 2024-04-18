package Controller;

import Services.Station;
import Services.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stations")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    // Endpoint para agregar una nueva estación
    @PutMapping("/{stationId}")
    public ResponseEntity<String> addStation(@PathVariable Long stationId, @RequestParam String name) {
        Station station = new Station() {
            @Override
            public Long getStationId() {
                return null;
            }
        };
        stationService.addStation(station);
        return ResponseEntity.status(HttpStatus.CREATED).body("Station added successfully");
    }

    // Endpoint para obtener una estación por su ID
    @GetMapping("/{stationId}")
    public ResponseEntity<Station> getStationById(@PathVariable Long stationId) {
        Station station = stationService.getStationById(stationId);
        if (station != null) {
            return ResponseEntity.ok(station);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para eliminar una estación por su ID
    @DeleteMapping("/{stationId}")
    public ResponseEntity<String> deleteStationById(@PathVariable Long stationId) {
        if (stationService.removeStation(stationId)) {
            return ResponseEntity.ok("Station deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

