package com.andrey.web2.Area;

import com.andrey.web2.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AboveLineTest {

    @Test
    void hit() {
        Area a1 = new AboveLine(0, -0.5, -1, 2);

        assertAll(
                () -> assertTrue(a1.hit(new Point(0, -0.5, 1))),
                () -> assertTrue(a1.hit(new Point(0, 0, 3))),
                () -> assertTrue(a1.hit(new Point(1, 0, 1))),
                () -> assertTrue(a1.hit(new Point(1, 0.5, 1))),
                () -> assertFalse(a1.hit(new Point(0, -1, 1))),
                () -> assertFalse(a1.hit(new Point(0, -1.001, 2))),
                () -> assertFalse(a1.hit(new Point(0, -1, 1))),
                () -> assertFalse(a1.hit(new Point(0, -1, 1)))
        );
    }
}