package com.natwest.prob;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/move")
class MoveController {
    private final Move move;

    public MoveController() {
        Set<String> obstacles = new HashSet<>(Arrays.asList("2,2", "3,3"));
        OceanGrid grid = new OceanGrid(5, 5, obstacles);
        this.move = new Move(0, 0, Direction.NORTH, grid);
    }

    @PostMapping("/{command}")
    public String moveProbe(@PathVariable String command) {
        switch (command.toUpperCase()) {
            case "FORWARD":
                move.moveForward();
                break;
            case "BACKWARD":
                move.moveBackward();
                break;
            case "LEFT":
                move.turnLeft();
                break;
            case "RIGHT":
                move.turnRight();
                break;
            default:
                return "Invalid command";
        }
        return "Probe moved to: (" + move.getX() + ", " + move.getY() + ") facing " + move.getDirection();
    }

    @GetMapping("/status")
    public Map<String, Object> getProbeStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("x", move.getX());
        status.put("y", move.getY());
        status.put("direction", move.getDirection());
        status.put("visited", move.getVisitedCoordinates());
        return status;
    }
}
