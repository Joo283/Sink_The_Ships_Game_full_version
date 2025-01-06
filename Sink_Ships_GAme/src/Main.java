import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playing_Game game = new Playing_Game();
        System.out.println("Enter the size of the grid (6-10): ");
        int sizeOfGrid = sc.nextInt();
        if (sizeOfGrid < 6 || sizeOfGrid > 10) {
            System.out.println("Grid size must be between 6 and 10. ");
            sc.close();
            return;
        }

        game.setSizeOfGrid(sizeOfGrid);
        game.startGame();

        sc.close();
    }
}
