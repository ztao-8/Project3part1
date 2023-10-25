import java.util.Random;

public class CleverAIPlayer implements WheelOfFortunePlayer {
    private StringBuilder guesslist = new StringBuilder("ETAONRISHDLFCMUGYPWBVKJXQZ");



    @Override
    public String playerId() {
        return "Clever AI player";
    }


    @Override
    public char nextGuess() {
        // gets 0, 1, or 2
        char guess = guesslist.charAt(0);
        guesslist.deleteCharAt(0);
        return guess;
    }

    @Override
    public void reset() {
        guesslist =  new StringBuilder("ETAONRISHDLFCMUGYPWBVKJXQZ");
    }
}
