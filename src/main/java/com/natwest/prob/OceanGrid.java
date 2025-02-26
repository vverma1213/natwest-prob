package com.natwest.prob;

import java.util.Set;

public class OceanGrid {

    private final int width, height;
    private final Set<String> obstacles;

    public OceanGrid(int width, int height, Set<String> obstacles) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Grid dimensions must be positive.");
        }
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    public boolean isValidMove(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height && !obstacles.contains(x + "," + y);
    }
}
