// this class is the main class for the game that takes the user input and runs the algorithm
// the class has a scanner object to take the user input
// the class has a variable to store the size of the grid
// the class has a variable to store the number of ships killed
// the class has a method that sets the size of the grid
// the class has a method that starts the game and takes user input and run the algorithm
// the class has a loop that sets the ships on the grid only 3 ships
// the class has a loop that takes the user input and runs the algorithm
// the class has a condition that checks if the user has sunk all the ships and print the number of all guesses
// the class has a condition that checks if the user's guess is a hit, miss or a kill and print the result



import java.util.*;
public class Playing_Game {
    private final Scanner sc = new Scanner(System.in);
    private int sizeOfGrid;
    private int shipsKilled = 3;
    //this method sets the size of the grid for the game
    public void setSizeOfGrid(int sizeOfGrid) {
        if (sizeOfGrid <= 0) {
            throw new IllegalArgumentException("Grid size must be greater than zero.");
        }
        this.sizeOfGrid = sizeOfGrid;
    }
    //this is the main method for the game that starts the game and takes user input and run the algorithm
    public void startGame() {
        PutDots putDots = new PutDots(sizeOfGrid);
        //this loop sets the ships on the grid only 3 ships
        for (int i = 0; i < 3; i++) {
            putDots.setDots(i);
        }
        //this method prints the grid for testing
//        System.out.println("Game started! Here's the initial grid:");
//        putDots.printGrid();
        //this loop takes the user input and runs the algorithm
        System.out.println("Game started! make sure to enter the coordinates between 1 and " + sizeOfGrid);
        while (true) {
            try {
                //this condition checks if the user has sunk all the ships and print the number of all guesses
                if (shipsKilled == 0) {
                    System.out.println("You sunk all the ships in " + putDots.getNumOfGuesses() + " guesses!");
                    break;
                }
                //this takes the user input and pass it to the checkYourself method
                System.out.print("Enter your guess (X Y): ");
                int guessX = sc.nextInt();
                int guessY = sc.nextInt();
                putDots.setUserGuessX(guessX);
                putDots.setUserGuessY(guessY);
                String result = putDots.checkYourself();
                //this condition checks if the user's guess is a hit, miss or a kill and print the result
                if (result.startsWith("hit")) {
                    System.out.println(result);
                } else if (result.startsWith("miss")) {
                    System.out.println("Missed! Try again.");
                } else if (result.startsWith("kill")) {
                    shipsKilled--;
                    System.out.println(result);
                }
                //if the user enters invalid input it catches the exception and print the message
                else {
                    System.out.println("Invalid input! Please enter valid coordinates.");
                }

            } // if the user enters invalid input it catches the exception and print the message
            catch (Exception e) {
                System.out.println("Invalid input! Please enter numeric coordinates.");
                sc.nextLine();
            }
        }
    }
}
