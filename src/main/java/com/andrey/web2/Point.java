package com.andrey.web2;

import com.andrey.web2.Area.Area;

public class Point {
    public double x;
    public double y;
    public double r;
    public boolean hit;

    public Point(double x, double y, double r, Area area) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = area.hit(this);
    }

    public Point(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public Point(double x, double y, double r, boolean hit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
    }
}
