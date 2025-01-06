import java.util.Vector;

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
    public PutDots(int size) {
        this.size = size;
        this.grid = new int[size][size];
        this.shipHits = new int[shipCount];
        initializeGrid();
    }
    private void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = 0;
            }
        }
    }
    public void setUserGuessX(int userGuessX) {
        this.userGuessX = userGuessX - 1;
    }

    public void setUserGuessY(int userGuessY) {
        this.userGuessY = userGuessY - 1;
    }
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
