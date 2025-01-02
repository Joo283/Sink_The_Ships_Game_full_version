import java.util.Scanner;

public class Playing_Game {
    Scanner sc = new Scanner(System.in);

    public void startGame() {
        int size;
        System.out.println("Enter the size of the Grid: ");
        size = sc.nextInt();
        PutDots put = new PutDots(size);
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
