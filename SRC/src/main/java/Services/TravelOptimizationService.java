package Services;


import model.Camino;
import model.Estacion;

import java.util.*;

public class TravelOptimizationService {

    private List<Estacion> estaciones;
    private List<Camino> caminos;

    public TravelOptimizationService(List<Camino> caminos) {
        this.estaciones = new ArrayList<>();
        this.caminos = new ArrayList<>();
    }

    public Estacion createEstacion(Estacion estacion) {
        estaciones.add(estacion);
        return estacion;
    }

    public Camino createCamino(Camino camino) {
        caminos.add(camino);
        return camino;
    }

    public Camino findCheapestPath(String origen, String destino) {
        // Mapeo de estaciones y costos desde la estación de origen
        Map<String, Double> costos = new HashMap<>();
        Map<String, Estacion> previo = new HashMap<>();
        PriorityQueue<String> cola = new PriorityQueue<>(Comparator.comparingDouble(costos::get));

        // Inicialización
        for (Estacion estacion : estaciones) {
            costos.put(estacion.getNombre(), Double.POSITIVE_INFINITY);
            previo.put(estacion.getNombre(), null);
        }
        costos.put(origen, 0.0);
        cola.add(origen);

        // Verificar si la estación de destino está en la lista de estaciones
        if (!costos.containsKey(destino)) {
            System.out.println("La estación de destino no se encuentra en la lista de estaciones.");
            return null;
        }

        // Algoritmo de Dijkstra
        while (!cola.isEmpty()) {
            String actual = cola.poll();
            if (actual.equals(destino)) {
                break;
            }
            for (Camino camino : caminos) {
                if (camino.getOrigen().getNombre().equals(actual)) {
                    double nuevoCosto = costos.get(actual) + camino.getCosto();
                    if (nuevoCosto < costos.get(camino.getDestino().getNombre())) {
                        costos.put(camino.getDestino().getNombre(), nuevoCosto);
                        previo.put(camino.getDestino().getNombre(), camino.getOrigen());
                        cola.add(camino.getDestino().getNombre());
                    }
                }
            }
        }

        // Reconstruir el camino óptimo
        List<Estacion> caminoOptimo = new ArrayList<>();
        String estacionActual = destino; // Usar la estación de destino como punto de partida
        while (previo.get(estacionActual) != null) {
            caminoOptimo.add(previo.get(estacionActual));
            estacionActual = previo.get(estacionActual).getNombre();
        }
        Collections.reverse(caminoOptimo);

        // Construir el objeto Camino resultante
        Camino caminoResultante = new Camino();
        caminoResultante.setOrigen(caminoOptimo.isEmpty() ? null : caminoOptimo.get(0));
        caminoResultante.setDestino(destino);
        caminoResultante.setCosto(costos.get(destino));

        return caminoResultante;
    }
}

