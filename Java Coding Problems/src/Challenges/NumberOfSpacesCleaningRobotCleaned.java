package Challenges;

/*
    A room is represented by a 0-indexed 2D binary matrix room where a 0 represents an empty space and a 1 represents a space with an object.
    The top left corner of the room will be empty in all test cases.
    A cleaning robot starts in the top left corner of the room and is facing right.
    The robot will continue heading straight until it reaches the edge of the room, or it hits an object, after which it will turn 90 degrees clockwise and repeat this process.
    The starting space and all spaces that the robot visits are cleaned by it.
    Return the number of clean spaces in the room if the robot runs indefinitely.
*/

import java.util.*;

public class NumberOfSpacesCleaningRobotCleaned {
//------------------------------------------------------------------- ATTEMPT (NOT COMPLETE) -------------------------------------------------------------------
    public static byte currentTurns = 0; // Will keep count how many times the robot turned in on position. If it > 3, we are stuck. end the loop.
    public static boolean stuck = false; // Boolean to determine if the robot is stuck. End the loop then
    public static int cleanedSpaces = 1; // Set to zero in the case that the robot cannot move. Cleaned only [0,0]

    public static byte turn(byte direction) {
        if(direction == 3) { // Update the direction of the robot
            direction = 0;
        } else {
            direction++;
        }
        currentTurns++; // We have turned, update the number of time we turned in this position

        if(currentTurns > 1) { // If we have turned more than 3 times, we are stuck
            stuck = true;
        }
        return direction;
    }

    public static void checkStartingPosition(int currentRow, int currentCol) { // Check if we are where we started [0,0]
        if (currentRow == 0 && currentCol == 0) {
            cleanedSpaces--;
            stuck = true;
        }
    }

    public static void addValue(Map<Integer, List<Integer>> map, Integer key, Integer value) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    // Method to check for the presence of a specific key-value pair
    public static boolean containsPair(Map<Integer, List<Integer>> map, Integer key, Integer value) {
        return map.containsKey(key) && map.get(key).contains(value);
    }

    public static int numberOfCleanRoomsO(int[][] room) {
        // Rows and Columns are equal to other Rows and Columns respectively. Get the bounds for our room now
        int totalRow = room.length-1;
        int totalCol = room[0].length-1;
        byte direction = 0;
        int movesWithoutTurning = 0;

        ArrayList<Integer> previousTurnsQueue = new ArrayList<>();
        Map<Integer, List<Integer>> previousTurns = new HashMap<>(); // Keep track of previous turn locations

        int currentRow = 0; // Gives current row position
        int currentCol = 0; // Gives current column position

        while(!stuck) {
            if(!previousTurns.isEmpty() && containsPair(previousTurns, currentRow, currentCol)) {
                stuck = true;
                cleanedSpaces = cleanedSpaces - movesWithoutTurning;
            }
            if(!previousTurnsQueue.isEmpty()) {
                addValue(previousTurns, currentRow, currentCol);
            }

            switch(direction) {
                case 0: // If we are facing right
                    // Check if the robot is on the right bound of the room or if the spot to the right is blocked
                    if(currentCol == totalCol || room[currentRow][currentCol+1] == 1) {
                        direction = turn(direction);
                        movesWithoutTurning = 0;
                        previousTurnsQueue.add(currentRow);
                        previousTurnsQueue.add(currentCol);
                    } else { // No issues, move the robot
                        currentCol++; // We moved to the right one
                        cleanedSpaces++; // We cleaned a space
                        checkStartingPosition(currentRow, currentCol); // Check if we are at the starting position
                        currentTurns = 0; // Reset currentTurns since we moved
                        movesWithoutTurning++;
                    }
                    break;
                case 1: // If we are facing down
                    // Check if the robot it on the bottom bound of the room or if the spot to the bottom is blocked
                    if(currentRow == totalRow || room[currentRow+1][currentCol] == 1) {
                        direction = turn(direction);
                        movesWithoutTurning = 0;
                        previousTurnsQueue.add(currentRow);
                        previousTurnsQueue.add(currentCol);
                    } else {
                        currentRow++; // We moved down one
                        cleanedSpaces++; // We cleaned a space
                        checkStartingPosition(currentRow, currentCol); // Check if we are at the starting position
                        currentTurns = 0; // Reset currentTurns since we moved
                        movesWithoutTurning++;
                    }
                    break;
                case 2: // If we are facing left
                    if(currentCol == 0 || room[currentRow][currentCol-1] == 1) {
                        direction = turn(direction);
                        movesWithoutTurning = 0;
                        previousTurnsQueue.add(currentRow);
                        previousTurnsQueue.add(currentCol);
                    } else {
                        currentCol--; // We moved to the left one
                        cleanedSpaces++; // We cleaned a space
                        checkStartingPosition(currentRow, currentCol); // Check if we are at the starting position
                        currentTurns = 0; // Reset currentTurns since we moved
                        movesWithoutTurning++;
                    }
                    break;
                case 3: // If we are facing up
                    if(currentRow == 0 || room[currentRow-1][currentCol] == 1) {
                        direction = turn(direction);
                        movesWithoutTurning = 0;
                        previousTurnsQueue.add(currentRow);
                        previousTurnsQueue.add(currentCol);
                    } else {
                        currentRow--; // We moved up one
                        cleanedSpaces++; // We cleaned a space
                        checkStartingPosition(currentRow, currentCol); // Check if we are at the starting position
                        currentTurns = 0; // Reset currentTurns since we moved
                        movesWithoutTurning++;
                    }
                    break;
                default:
                    break;

            }
        }
        currentTurns = 0;
        stuck = false;
        int output = cleanedSpaces;
        cleanedSpaces = 1;
        return output;
    }

//----------------------------------------------------- OFFICIAL SOLUTION -----------------------------------------------------
public static final int[] DIRECTIONS = { 0, 1, 0, -1, 0 };
public static int numberOfCleanRooms(int[][] room) {
    int rows = room.length;
    int cols = room[0].length;
    Set<String> visited = new HashSet<>();
    Set<String> cleaned = new HashSet<>();
    return clean(room, rows, cols, 0, 0, 0, visited, cleaned);
}

public static int clean(
        int[][] room,
        int rows,
        int cols,
        int row,
        int col,
        int direction,
        Set<String> visited,
        Set<String> cleaned
) {
    // If the robot already visited this space facing this direction
    // Return the number of spaces cleaned
    if (visited.contains(row + "," + col + "," + direction)) {
        return cleaned.size();
    }

    // Mark the space as visited facing this direction and cleaned
    visited.add(row + "," + col + "," + direction);
    cleaned.add(row + "," + col);

    // Clean the next space straight ahead if it's empty and in the room
    int nextRow = row + DIRECTIONS[direction];
    int nextCol = col + DIRECTIONS[direction + 1];
    if (
            0 <= nextRow &&
                    nextRow < rows &&
                    0 <= nextCol &&
                    nextCol < cols &&
                    room[nextRow][nextCol] == 0
    ) {
        return clean(
                room,
                rows,
                cols,
                nextRow,
                nextCol,
                direction,
                visited,
                cleaned
        );
    }

    // Otherwise turn right and clean the current space
    return clean(
            room,
            rows,
            cols,
            row,
            col,
            (direction + 1) % 4,
            visited,
            cleaned
    );
}


//------------------------------------------------------- MAIN METHOD -------------------------------------------------------
    public static void main(String[] args) {
        int[][] roomOne = {
                {0,0,0},
                {1,1,0},
                {0,0,0}
        };
        int[][] roomTwo = {
                {0,1,0},
                {1,0,0},
                {0,0,0}
        };
        int[][] roomThree = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };

        int[][] roomFour = {
            {0,0,0,0,0},
            {0,0,1,0,0}
        };


        long bruteStart = System.nanoTime(); // Start timer for brute force
        System.out.println("Attempt: " + numberOfCleanRoomsO(roomOne));
        System.out.println("Attempt: " + numberOfCleanRoomsO(roomTwo));
        System.out.println("Attempt: " + numberOfCleanRoomsO(roomThree));
        System.out.println("Attempt: " + numberOfCleanRoomsO(roomFour));
        long bruteEnd = System.nanoTime(); // End Timer
        System.out.println("First Attempt Time: " + (bruteEnd - bruteStart) / 1000 + " microseconds");

        System.out.println("\n----------------------------------------------------------------------------------\n");

        long solutionStart = System.nanoTime(); // Start timer for brute force
        System.out.println(numberOfCleanRooms(roomOne));
        System.out.println(numberOfCleanRooms(roomTwo));
        System.out.println(numberOfCleanRooms(roomThree));
        long solutionEnd = System.nanoTime(); // End Timer
        System.out.println("Offical Solution Time: " + (solutionEnd - solutionStart) / 1000 + " microseconds");

    }
}
