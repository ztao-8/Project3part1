import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class WheelOfFurtune extends Game{
    protected static List<String> phList;
    protected static String phrase;
    protected String filename;
    protected static StringBuilder secret;
    protected static int score = 26;

    public WheelOfFurtune(String filename){
        this.filename = filename;
        readPhrases(filename);
    }

    public void readPhrases(String filename){
        List<String> phraseList= new ArrayList<String>();
        // Get the phrase from a file of phrases
        try {
            phraseList = Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            System.out.println(e);
        }
        phList = phraseList;
    }
    public void randomPhrase(){
        Random rand = new Random();
        int r = rand.nextInt(phList.size()); // gets 0, 1, or 2
        phrase = phList.get(r);
        phList.remove(r) ;
    }

    public StringBuilder getHiddenPhrase(){
        StringBuilder Hidden = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++ ){
            char ch = phrase.charAt(i);
            if (Character.isLetter(ch)){
                Hidden.append("*");
            }
            else{
                Hidden.append(ch);
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
