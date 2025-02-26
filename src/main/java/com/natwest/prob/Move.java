package com.natwest.prob;

import java.util.LinkedHashSet;
import java.util.Set;

public class Move {

    private int x, y;
    private Direction direction;
    private final OceanGrid grid;
    private final Set<String> visited;

    public Move(int x, int y, Direction direction, OceanGrid grid) {
        if (!grid.isValidMove(x, y)) {
            throw new IllegalArgumentException("Invalid initial position: " + x + "," + y);
        }
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
        this.visited = new LinkedHashSet<>();
        recordPosition();
    }

    private void recordPosition() {
        visited.add(x + "," + y);
    }

    public void moveForward() {
        move(1);
    }

    public void moveBackward() {
        move(-1);
    }

    private void move(int step) {
        int newX = x, newY = y;
        switch (direction) {
            case NORTH -> newY += step;
            case SOUTH -> newY -= step;
            case EAST -> newX += step;
            case WEST -> newX -= step;
        }
        if (grid.isValidMove(newX, newY)) {
            x = newX;
            y = newY;
            recordPosition();
        }
    }

    public void turnLeft() {
        direction = direction.left();
    }

    public void turnRight() {
        direction = direction.right();
    }

    public Set<String> getVisitedCoordinates() {
        return new LinkedHashSet<>(visited);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}
