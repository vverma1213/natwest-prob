# Requirement

* You have a defined grid representing the ocean floor where location can be identified using x/y co-ordinates.
* You are given an initial starting point (x,y) for the probe and the direction it is facing.
* The probe will receive a collection of commands.
* It should be able to:
* Move forwards and backwards.
* Turn left and right.
* Stay on the grid.
* Avoid obstacles in the grid.
* Print a summary of the co-ordinates visited.

# Test

* POST - localhost:8080/move/FORWARD
* POST - localhost:8080/move/LEFT
* POST - localhost:8080/move/FORWARD
* POST - localhost:8080/move/RIGHT
* GET - localhost:8080/move/status

# OUTPUT

{
"x": 0,
"visited": [
"0,0"
],
"y": 0,
"direction": "NORTH"
}
