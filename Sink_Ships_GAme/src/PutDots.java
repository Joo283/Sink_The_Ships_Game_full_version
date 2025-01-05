//This Class is responsible for the prebaration of the grid
//It creates the grid and places the dots on the grid randomly
//It also checks the user input and returns the result of the check to the Playing_Game class
//It also keeps track of the number of guesses made by the user
//the main data structure used in this class is an array


public class PutDots {
    private int[] locationCils;
    private int numOfHits = 0;
    private int userGuesses;
    private int numOfGuesses = 0;
    public PutDots(int size) {
        locationCils = new int[size+1];
        for (int i = 0; i <= size; i++) {
            locationCils[i] =0;

        }
        int firstHit = (int) (Math.random() * size);
        for (int i = firstHit; i < firstHit +3; i++) {
            locationCils[i] =1;
        }

    }

    public String checkYourself(int userGuesses)
    {
        numOfGuesses++;
        this.userGuesses = userGuesses;
        String answer = "";
        if(locationCils[userGuesses] == 1)
        {
            numOfHits++;
            locationCils[userGuesses] = 0;
            answer = "hit";



        }
        else
            answer = "lost";
        if(numOfHits == 3)
        {
            answer = "kill";

        }
        return answer;

    }

    public int getNumOfGuesses() {
        return numOfGuesses;
    }
}
