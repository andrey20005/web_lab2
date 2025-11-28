package com.andrey.web2.Area;


import com.andrey.web2.Point;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record Circle(double radius, double x, double y) implements Area {

    @Override
    public boolean hit(Point point) {
        return Math.pow(point.x/point.r - x, 2) + Math.pow(point.x/point.r - y, 2) <= Math.pow(radius, 2);
    }
}
