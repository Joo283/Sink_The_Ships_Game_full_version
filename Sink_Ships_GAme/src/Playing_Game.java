//this Class is responsible for the logic of the game
//It takes the size of the grid as input from the Main Class and sets the size of the grid
//the main logic of the game that its check the String that is returned from the PutDots class and prints the result of the check
//It also prints the number of guesses made by the user after the game is over
import java.util.Scanner;

public class Playing_Game {
    Scanner sc = new Scanner(System.in);
    private int sizeOfGrid = 0;

    public void setSizeOfGrid(int sizeOfGrid) {
        this.sizeOfGrid = sizeOfGrid;


    }

    public void startGame() {
        PutDots put = new PutDots(sizeOfGrid);
        while (true) {
            System.out.println("enter a number : ");
            int num = sc.nextInt();
            String check = put.checkYourself(num);
            if ( check.equals("hit")) {
                System.out.println("hit");
            } else if (check.equals("lost") ) {
                System.out.println("miss");
            } else if (check.equals("kill")) {
                System.out.println("Kill");
                System.out.println("you took " + put.getNumOfGuesses() + " guesses");
                break;
            }
        }
    }
}
