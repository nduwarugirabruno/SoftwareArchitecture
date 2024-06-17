package io.ahp.tp.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Path {
    private String path;
    private double distance, traffic, duration, roadCondition;

    public Path(String brand, double distance, double traffic, double duration, double roadCondition) {
        this.path = brand;
        this.distance = distance;
        this.traffic = traffic;
        this.duration = duration;
        this.roadCondition = roadCondition;
    }

    @Override
    public String toString() {
        return "\n\tPath ->" +
                "\n\t\tpath: " + path +
                "\n\t\tdistance: " + distance +
                "\n\t\ttraffic: " + traffic +
                "\n\t\tduration: " + duration +
                "\n\t\troadCondition: " + roadCondition;
    }
}
