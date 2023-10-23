public class DefaultAIPlayer implements WheelOfFortunePlayer{
    private StringBuilder guesslist = new StringBuilder("abcdefghijklmnopqrstuvwxyz");

    @Override
    public String playerId() {
        return "Default AI player";
    }

    @Override
    public void reset() {
        phrase = WheelOfFurtune.randomPhrase();
        secret = new StringBuilder(getHiddenPhrase());
        score = 26;
        System.out.println(secret);
    }
}
