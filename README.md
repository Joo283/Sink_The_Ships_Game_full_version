# Sink The Ships Game (Full Version)

## Overview
Sink The Ships Game (Full Version) is a simple text-based game where the player tries to sink ships placed randomly on a grid. The player enters guesses as coordinates, and the game provides feedback about hits, misses, or kills. The goal is to sink all the ships in the fewest number of guesses.

## Features
- Configurable grid size (between 4x4 and 10x10).
- Random ship placement on the grid.
- Three ships, each 3 cells long.
- Real-time feedback on guesses.
- Tracks and displays the number of guesses used to sink all ships.

## How It Works
1. The game starts by prompting the user to enter the grid size (between 4 and 10).
2. Three ships are randomly placed on the grid.
3. The user inputs guesses as coordinates (X Y) until all ships are sunk.
4. The game provides feedback for each guess:
   - "hit": A part of the ship was hit.
   - "miss": The guess did not hit any ship.
   - "kill": The entire ship was sunk.
5. The game ends when all three ships are sunk, and the total number of guesses is displayed.

## Classes and Responsibilities

### Main Class
- **Purpose**: Handles user input, validates grid size, and starts the game.
- **Key Methods**:
  - `main(String[] args)`: Prompts for grid size, validates it, and initiates the game.

### Playing_Game Class
- **Purpose**: Manages the gameplay loop, tracks ships sunk, and interacts with the `PutDots` class for grid and ship management.
- **Key Methods**:
  - `setSizeOfGrid(int sizeOfGrid)`: Sets the grid size.
  - `startGame()`: Core game logic including user input, feedback, and win conditions.

### PutDots Class
- **Purpose**: Handles grid management, ship placement, and guess evaluation.
- **Key Methods**:
  - `initializeGrid()`: Initializes the grid with default values.
  - `setDots(int shipNum)`: Places ships on the grid randomly.
  - `checkPlacement(int startX, int startY, int direction)`: Validates if a ship can be placed at a location.
  - `placeDots(int startX, int startY, int direction, int shipNum)`: Places ship parts on the grid.
  - `checkYourself()`: Evaluates user guesses for hits, misses, or kills.
  - `getNumOfGuesses()`: Returns the total number of guesses made.

### Pair Class
- **Purpose**: Utility class for storing coordinate pairs (used for ship coordinates).
- **Key Methods**:
  - `Pair(K key, V value)`: Constructor to initialize key-value pairs.
  - `getKey()`: Retrieves the key.
  - `getValue()`: Retrieves the value.

## Gameplay Instructions
1. Run the program.
2. Enter the grid size when prompted (valid range: 4-10).
3. Enter guesses as coordinates (e.g., `3 4` for row 3, column 4).
4. Continue guessing until all ships are sunk.
5. The game will display the number of guesses used.

## Example Run
```
Enter the size of the grid (4-10): 5
Game started! Make sure to enter the coordinates between 1 and 5.
Enter your guess (X Y): 3 2
Missed! Try again.
Enter your guess (X Y): 1 1
Hit ship 1
Enter your guess (X Y): 1 2
Hit ship 1
Enter your guess (X Y): 1 3
Kill ship 1
...
You sunk all the ships in 15 guesses!
```

## Requirements
- Java Development Kit (JDK) 8 or later

## How to Run
1. Compile the program using:
   ```
   javac Main.java Playing_Game.java PutDots.java
   ```
2. Run the program:
   ```
   java Main
   ```

## Future Enhancements
- Add a graphical user interface (GUI) for better user experience.
- Allow the user to configure the number of ships and their sizes.
- Add multiplayer support.
- Introduce difficulty levels with varying numbers of ships or grid sizes.


---
Enjoy playing Sink The Ships Game (Full Version) and have fun sinking those ships!

