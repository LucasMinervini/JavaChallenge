package model;

public class Estacion {
    private String nombre;
    private Long stationId;

    public Estacion(String nombre, Long stationId) {
        this.nombre = nombre;
        this.stationId = stationId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getStationId(){
        return stationId;
    }
}
