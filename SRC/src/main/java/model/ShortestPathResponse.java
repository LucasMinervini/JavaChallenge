package model;

import java.util.List;

public class ShortestPathResponse {
    private List<Long> path;
    private double cost;

    public ShortestPathResponse(List<Long> path, double cost) {
        this.path = path;
        this.cost = cost;
    }

    public ShortestPathResponse() {

    }

    public List<Long> getPath() {
        return path;
    }

    public void setPath(List<Long> path) {
        this.path = path;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
