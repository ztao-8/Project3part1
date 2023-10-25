import java.util.Random;

public class CleverAIPlayer implements WheelOfFortunePlayer {
    private StringBuilder guesslist = new StringBuilder("ETAONRISHDLFCMUGYPWBVKJXQZ");



    @Override
    public String playerId() {
        return "Clever AI player";
    }


    @Override
    public char nextGuess() {
        Random rand = new Random();
        int num = rand.nextInt(guesslist.length()); // gets 0, 1, or 2
        char guess = guesslist.charAt(num);
        guesslist.deleteCharAt(num);
        return guess;
    }

    @Override
    public void reset() {
        guesslist =  new StringBuilder("ETAONRISHDLFCMUGYPWBVKJXQZ");
    }
}
