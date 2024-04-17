package Controller;

import Services.TravelOptimizationService;
import model.Camino;
import model.Estacion;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TravelOptimizationController {

    private final TravelOptimizationService service;

    public TravelOptimizationController(TravelOptimizationService service) {
        this.service = service;
    }

    @PostMapping("/estaciones")
    public Estacion createEstacion(@RequestBody Estacion estacion) {
        return service.createEstacion(estacion);
    }
    @PostMapping("/caminos")
    public Camino createCamino(@RequestBody Camino camino) {
        return service.createCamino(camino);
    }

    @GetMapping("/cheapest-path")
    public Camino findCheapestPath(@RequestParam String origin, @RequestParam String destination) {
        return service.findCheapestPath(origin, destination);
    }
}
