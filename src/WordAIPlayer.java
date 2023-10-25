import java.util.Random;

public class WordAIPlayer implements WheelOfFortunePlayer  {
    private StringBuilder guesslist = new StringBuilder("thebetoofandinmehaveorsaywillupjustgoknowqvxz");

    private String previousGuess;

    @Override
    public String playerId() {
        return "Word AI player";
    }


    @Override
    public char nextGuess() {
        char guess = guesslist.charAt(0);
        while (this.previousGuess.indexOf( Character.toLowerCase(guess)) != -1){
            System.out.println("You already guessed this character!");
            guess = guesslist.charAt(0);
        }
        previousGuess += guess;
        guesslist.deleteCharAt(0);
        return guess;
    }

    @Override
    public void reset() {
        guesslist =  new StringBuilder("ETAONRISHDLFCMUGYPWBVKJXQZ");
        previousGuess = "";
    }

}
