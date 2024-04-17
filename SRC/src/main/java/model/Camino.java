package model;

public class Camino {
    private double costo;
    private Estacion origen;
    private Estacion destino;

    public Camino() {
    }

    public Camino(double costo, Estacion origen, Estacion destino) {
        this.costo = costo;
        this.origen = origen;
        this.destino = destino;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Estacion getOrigen() {
        return origen;
    }

    public void setOrigen(Estacion origen) {
        this.origen = origen;
    }

    public Estacion getDestino() {
        return destino;
    }

    public void setDestino(Estacion destino) {
        this.destino = destino;
    }

    public void setDestino(String destino) {
    }
}
