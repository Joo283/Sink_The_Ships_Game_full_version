//this is the main class where the game starts
//this class takes the size of the grid from the user and starts the game
//the class has a main method that takes the size of the grid from the user and starts the game
//the class has a condition that checks if the grid size is between 4 and 10
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playing_Game game = new Playing_Game();
        System.out.println("Enter the size of the grid (4-10): ");
        int sizeOfGrid = sc.nextInt();
        if (sizeOfGrid < 4 || sizeOfGrid > 10) {
            System.out.println("Grid size must be between 4 and 10. ");
            sc.close();
            return;
        }

        game.setSizeOfGrid(sizeOfGrid);
        game.startGame();

        sc.close();
    }
}
