//This is the main class where the game starts
//It creates an object of Playing_Game class and calls the startGame method
//It takes the size of the grid as input from the user and sets the size of the grid after checking the constraints
//It then calls the startGame method to start the game


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playing_Game game = new Playing_Game();
        System.out.println("enter the size of grid : ");
        int sizeOfGrid = sc.nextInt();
        if (sizeOfGrid < 3) {
            System.out.println("size of grid should be greater than 3");
            return;
        }
        else if (sizeOfGrid > 15) {
            System.out.println("size of grid should be less than 15");
            return;
        }
        else
            game.setSizeOfGrid(sizeOfGrid);
        game.startGame();








    }
}