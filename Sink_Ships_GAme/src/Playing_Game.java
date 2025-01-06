import java.util.Scanner;
public class Playing_Game {
    private final Scanner sc = new Scanner(System.in);
    private int sizeOfGrid;
    private int shipsKilled = 3;
    public void setSizeOfGrid(int sizeOfGrid) {
        if (sizeOfGrid <= 0) {
            throw new IllegalArgumentException("Grid size must be greater than zero.");
        }
        this.sizeOfGrid = sizeOfGrid;
    }
    public void startGame() {
        PutDots putDots = new PutDots(sizeOfGrid);
        for (int i = 0; i < 3; i++) {
            putDots.setDots(i);
        }
//        System.out.println("Game started! Here's the initial grid:");
//        putDots.printGrid();
        while (true) {
            try {
                if (shipsKilled == 0) {
                    System.out.println("You sunk all the ships in " + putDots.getNumOfGuesses() + " guesses!");
                    break;
                }
                System.out.print("Enter your guess (X Y): ");
                int guessX = sc.nextInt();
                int guessY = sc.nextInt();
                putDots.setUserGuessX(guessX);
                putDots.setUserGuessY(guessY);
                String result = putDots.checkYourself();

                if (result.startsWith("hit")) {
                    System.out.println(result);
                } else if (result.startsWith("miss")) {
                    System.out.println("Missed! Try again.");
                } else if (result.startsWith("kill")) {
                    shipsKilled--;
                    System.out.println(result);
                }else {
                    System.out.println("Invalid input! Please enter valid coordinates.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter numeric coordinates.");
                sc.nextLine();
            }
        }
    }
}
