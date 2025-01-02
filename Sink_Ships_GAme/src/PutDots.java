public class PutDots {
    private int[] locationCils;
    private int numOfHits = 0;
    private int userGuesses;
    private int numOfGuesses = 0;
    public PutDots(int size) {
        locationCils = new int[size];
        for (int i = 0; i < size; i++) {
            locationCils[i] =0;

        }
        int firstHit = (int) (Math.random() * size);
        for (int i = firstHit; i < firstHit +3; i++) {
            locationCils[i] =1;
        }

    }
    public void print()
    {

        for (int i = 0; i < locationCils.length; i++) {
            System.out.print(locationCils[i] + " ");
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
