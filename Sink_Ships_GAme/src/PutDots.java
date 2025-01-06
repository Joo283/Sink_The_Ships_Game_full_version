//this class is responsible for setting the dots on the grid randomly and checking if the user's guess is a hit, miss or a kill
//tha main data structure used in this class is a 2D array to represent the grid and a vector to store the ship coordinates
//the class has a constructor that takes the size of the grid as a parameter and initializes the grid with 0
//the class has a method that sets the user's guess for X coordinate
//the class has a method that sets the user's guess for Y coordinate
//the class has a method that sets the dots on the grid randomly by random start point
//the class has a method that checks if the ship can be placed on the grid or not
//the class has a method that places the dots on the grid according to the direction its comming from checkPlacement method and setDots method
//the class has a method that checks if the user's guess is a hit, miss or a kill and pass the result to Playing_Game Class
//the class has a getter for number of guesses to pass to Playing_Game
//the class has a print method for testing
//the class has a pair class for storing


import java.util.*;

public class PutDots {
    private int[][] grid;
    private int userGuessX;
    private int userGuessY;
    private int numOfGuesses = 0;
    private int size;
    private static final int DOT_LENGTH = 3;
    private int shipCount = 3;
    private int[] shipHits;
    private Vector<Pair<Integer, Integer>> shipCoordinates = new Vector<>(3);
    //constructor for PutDots class
    public PutDots(int size) {
        this.size = size;
        this.grid = new int[size][size];
        this.shipHits = new int[shipCount];
        initializeGrid();
    }
    //this method initializes the grid with 0
    private void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = 0;
            }
        }
    }
    //this method sets the user's guess for X coordinate
    public void setUserGuessX(int userGuessX) {
        // Subtract 1 because the user input is 1-based
        this.userGuessX = userGuessX - 1;
    }
    //this method sets the user's guess for Y coordinate
    public void setUserGuessY(int userGuessY) {
        // Subtract 1 because the user input is 1-based
        this.userGuessY = userGuessY - 1;
    }
    //this method sets the dots on the grid randomly by random start point and random direction
    public void setDots(int shipNum) {
        int startX, startY, direction;
        do {
            startX = (int) (Math.random() * size);
            startY = (int) (Math.random() * size);
            direction = (int) (Math.random() * 4);
        } while (!checkPlacement(startX, startY, direction));

        placeDots(startX, startY, direction, shipNum);
        shipCoordinates.add(new Pair<>(startX, startY));
    }
    //this method checks if the ship can be placed on the grid or not
    private boolean checkPlacement(int startX, int startY, int direction) {
        for (int i = 0; i < DOT_LENGTH; i++) {
            int x = startX, y = startY;
            switch (direction) {
                case 0: x = startX + i; break;  // Right
                case 1: y = startY + i; break;  // Down
                case 2: x = startX - i; break;  // Left
                case 3: y = startY - i; break;  // Up
            }
            if (x < 0 || x >= size || y < 0 || y >= size || grid[x][y] != 0) {
                return false;
            }
        }
        return true;
    }
    //this method places the dots on the grid according to the direction its comming from checkPlacement method and setDots method
    private void placeDots(int startX, int startY, int direction, int shipNum) {
        for (int i = 0; i < DOT_LENGTH; i++) {
            int x = startX, y = startY;

            switch (direction) {
                case 0: x = startX + i; break;  // Right
                case 1: y = startY + i; break;  // Down
                case 2: x = startX - i; break;  // Left
                case 3: y = startY - i; break;  // Up
            }

            grid[x][y] = shipNum + 1;
        }
    }
    //this method checks if the user's guess is a hit, miss or a kill and pass the result to Playing_Game Class
    public String checkYourself() {
        numOfGuesses++;

        if (userGuessX < 0 || userGuessX >= size || userGuessY < 0 || userGuessY >= size) {
            return "Invalid guess location";
        }
        int cell = grid[userGuessX][userGuessY];

        if (cell > 0) {
            int hitShipNum = cell - 1;
            grid[userGuessX][userGuessY] = 0;
            shipHits[hitShipNum]++;

            if (shipHits[hitShipNum] == DOT_LENGTH) {
                return "kill ship " + (hitShipNum + 1);
            }
            return "hit ship " + (hitShipNum + 1);
        }
        return "miss";
    }
    //getter for number of guesses to pass to Playing_Game
    public int getNumOfGuesses() {
        return numOfGuesses;
    }
    //print for testing
    public void printGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    //pair class for storing ship coordinates
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
