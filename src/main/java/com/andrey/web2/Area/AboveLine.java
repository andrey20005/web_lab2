package com.andrey.web2.Area;


import com.andrey.web2.Point;

public record AboveLine(double centerX, double centerY, double normX, double normY) implements Area {
    @Override
    public boolean hit(Point point) {
        return (point.x/point.r)*normX + (point.y/point.r)*normY >= 0;
    }
}
