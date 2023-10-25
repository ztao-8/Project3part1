import java.util.List;

public class WheelOfFortuneAIGame extends WheelOfFurtune {
    private int index = 0;
    private int playerind = 0;
    private List<WheelOfFortunePlayer> players;
    private WheelOfFortunePlayer player;


    public WheelOfFortuneAIGame(String filename){
        super(filename);
        this.players = List.of(new DefaultAIPlayer());
    }
    public WheelOfFortuneAIGame(String filename,WheelOfFortunePlayer player) {
        super(filename);
        this.players = List.of(player);
    }
    public WheelOfFortuneAIGame(String filename, List<WheelOfFortunePlayer> players) {
        super(filename);
        this.players = players;
    }

    public GameRecord play(){
        randomPhrase();
        getHiddenPhrase();
        System.out.println(secret);
        player.reset();
        String id = player.playerId();
        while (!secret.toString().equals(phrase)){
            char guess = getGuess();
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
        if (playerind < players.size()){
            player = players.get(playerind);
            if (index < phList.size()){
                index ++;
                return true;
            }
            playerind++;
            index = 0;
            phList = readPhrases(filename);
            return playNext();
        }
        return false;
    };
    public char getGuess(){
        return player.nextGuess();
    };
    public static void main(String[] args) {
        WheelOfFortuneAIGame game = new WheelOfFortuneAIGame("phrases.txt");
        AllGameRecord record = game.playAll();
        System.out.println(record);
    }


}
