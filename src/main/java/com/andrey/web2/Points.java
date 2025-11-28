package com.andrey.web2;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Named("pointsBean")
@SessionScoped
public class Points implements Serializable {
    private Map<LocalDateTime, Point> points = new HashMap<>();

    public void addPoint(Point point) {
        points.put(LocalDateTime.now(), point);
    }

    public Map<LocalDateTime, Point> getPoints() {
        return points;
    }

    public void setPoints(Map<LocalDateTime, Point> points) {
        this.points = points;
    }
}
