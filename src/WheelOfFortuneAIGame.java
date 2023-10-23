import java.util.List;

public class WheelOfFortuneAIGame extends WheelOfFurtune {
    private int index = 0;
    private List<WheelOfFortunePlayer> players;
    private StringBuilder guesslist = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
    public WheelOfFortuneAIGame(String filename){
        phList = readPhrases(filename);
        this.players = List.of(new DefaultAIPlayer());
    }
    public WheelOfFortuneAIGame(String filename,WheelOfFortunePlayer player) {
        phList = readPhrases(filename);
        this.players = List.of(player);
    }
    public WheelOfFortuneAIGame(String filename, List<WheelOfFortunePlayer> players) {
        phList = readPhrases(filename);
        this.players = players;
    }
    @Override
    public AllGameRecord playAll(){
        AllGameRecord allrecords  = new AllGameRecord();
        while (playNext()){
            phrase = randomPhrase();
            while (index < players.size()) {
                GameRecord record = play();
                index ++;
                allrecords.add(record);
            }
            index = 0;
        }
        return allrecords;
    }
    public GameRecord play(){
        WheelOfFortunePlayer player  = players.get(index);
        player.reset();
        String id = player.playerId();
        while (!secret.toString().equals(phrase)){
            char guess = player.nextGuess();
            if (!processGuess(guess)){
                score -= 1;
                System.out.println("There is no " + guess + " in the phrase.");
            }
            else{
                System.out.println(secret);
            };
        }
        GameRecord newrecord = new GameRecord(score,id);
        return newrecord;
    }
    public boolean playNext(){
        if (phList.isEmpty()){
            return false;
        }
        else{return true;}
    };
    public char getGuess(){
        return guesslist.charAt(0);
    };


}
