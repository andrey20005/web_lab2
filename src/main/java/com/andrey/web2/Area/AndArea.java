package com.andrey.web2.Area;


import com.andrey.web2.Point;

import java.util.Collection;

public record AndArea(Collection<Area> areas) implements Area {

    public void addArea(Area area) {
        areas.add(area);
    }

    @Override
    public boolean hit(Point point) {
        return areas.stream().allMatch(area -> area.hit(point));
    }
}
