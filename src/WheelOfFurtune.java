import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class WheelOfFurtune extends Game{
    protected List<String> phList;
    protected String phrase;
    protected StringBuilder secret;
    protected int score = 26;
    //protected int time = 10;
    public List<String> readPhrases(String filename){
        List<String> phraseList= new ArrayList<String>();
        // Get the phrase from a file of phrases
        try {
            phraseList = Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            System.out.println(e);
        }
        this.phList = phraseList;
        return phraseList;
    }
    public String randomPhrase(){
        Random rand = new Random();
        int r = rand.nextInt(phList.size()); // gets 0, 1, or 2
        this.phrase = phList.get(r);
        phList.remove(r) ;
        return phrase;
    }

    public String getHiddenPhrase(){
        String Hidden = "";
        for (int i = 0; i < phrase.length(); i++ ){
            char ch = phrase.charAt(i);
            if (Character.isLetter(ch)){
                Hidden += "*";
            }
            else{
                Hidden += ch;
            }
        }
        return Hidden;
    }

    public boolean processGuess(char guesschar){
        boolean ans = false;
        for (int i = 0; i < secret.length(); i++){
            char character  = phrase.charAt(i);
            if (Character.toLowerCase(guesschar) == Character.toLowerCase(character)){
                secret.setCharAt(i,character);
                ans = true;
            }
        }
        return ans;
    }

    public abstract GameRecord play();
    public abstract  boolean playNext();
    public abstract char getGuess();

}
