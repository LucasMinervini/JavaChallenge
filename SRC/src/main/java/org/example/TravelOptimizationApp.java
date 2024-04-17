package org.example;

import Services.TravelOptimizationService;
import model.Camino;
import model.Estacion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TravelOptimizationApp {

    public static void main(String[] args) {
        SpringApplication.run(TravelOptimizationApp.class, args);

        // Crear algunas estaciones
        List<Estacion> estacions = new ArrayList<>();
        Estacion estacionA = new Estacion("Estación A");
        Estacion estacionB = new Estacion("Estación B");
        Estacion estacionC = new Estacion("Estación C");

        // Crear algunos caminos
        List<Camino> caminos = new ArrayList<>();
        caminos.add(new Camino(10.0, estacionA, estacionB));
        caminos.add(new Camino(20.0, estacionB, estacionC));
        caminos.add(new Camino(15.0, estacionA, estacionC));

        // Crear el servicio de optimización de viajes
        TravelOptimizationService service = new TravelOptimizationService(caminos);

        // Consultar el camino más barato entre dos estaciones
        String origen = "Estación A";
        String destino = "Estación C";
        Camino caminoMasBarato = service.findCheapestPath(origen, destino);
        if (caminoMasBarato != null) {
            System.out.println("El camino más barato desde " + origen + " hasta " + destino + " es de costo " + caminoMasBarato.getCosto());
        } else {
            System.out.println("No se encontró ningún camino desde " + origen + " hasta " + destino);
        }
    }
}