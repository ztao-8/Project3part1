import java.util.ArrayList;
import java.util.List;

public class WheelOfFortuneAIGame extends WheelOfFurtune {
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
        secret = getHiddenPhrase();
        System.out.println(secret);
        score = 26;
        player.reset();
        String id = player.playerId();
        while (!secret.toString().equals(phrase)){
            char guess = getGuess();
            if (!processGuess(guess)){
                score -= 1;
                System.out.println(score);
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
            if (!phList.isEmpty()){
                return true;
            }
            playerind++;
            readPhrases(filename);
            return playNext();
        }
        return false;
    };
    public char getGuess(){
        return player.nextGuess();
    };
    public static void main(String[] args) {
        List<WheelOfFortunePlayer> players = new ArrayList<>();
        players.add(new DefaultAIPlayer());
        players.add(new CleverAIPlayer());
        players.add(new WordAIPlayer());
        WheelOfFortuneAIGame game3 = new WheelOfFortuneAIGame("phrases.txt", players);
        AllGameRecord record = game3.playAll();
        System.out.println(record);
        List highList = record.highGameList(3);
        System.out.println(highList);

    }


}
