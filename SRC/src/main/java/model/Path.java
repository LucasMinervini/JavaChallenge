package model;

public class Path {
    private Long pathId;
    private Long sourceId;
    private Long destinationId;
    private double cost;

    public Path(Long pathId, Long sourceId, Long destinationId, double cost) {
        this.pathId = pathId;
        this.sourceId = sourceId;
        this.destinationId = destinationId;
        this.cost = cost;
    }

    public Long getPathId() {
        return pathId;
    }

    public void setPathId(Long pathId) {
        this.pathId = pathId;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
