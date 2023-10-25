import java.util.Scanner;

public class WheelOfFortuneUserGame extends WheelOfFurtune{
    private String previousGuess = "";
    public WheelOfFortuneUserGame(String filename){
        super(filename);
    }
    @Override
    public char getGuess() {
        char guess;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a Character:");
        guess = scanner.next().charAt(0);
        while (!Character.isLetter(guess)) {
            guess = scanner.next().charAt(0);
        }
        return guess;
    }

    public char nextGuess() {
        char guess = getGuess();
        while (this.previousGuess.indexOf( Character.toLowerCase(guess)) != -1){
            System.out.println("You already guessed this character!");
            guess = getGuess();
        }
        previousGuess += guess;
        return guess;
    }

    private String getId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your id:");
        String id = scanner.next();
        return id;
    }

    @Override
    public GameRecord play() {
        String id = getId();
        score = 26;
        randomPhrase();
        secret = new StringBuilder(getHiddenPhrase());
        System.out.println(secret);
        while (!secret.toString().equals(phrase)){
            char guess = nextGuess();
            if (processGuess(guess)){
                System.out.println(secret);
            }
            else{
                score -= 1;
                System.out.println("There is no " + guess + " in the phrase.");
            }
        }
        GameRecord newrecord = new GameRecord(score,id);
        System.out.println("Congratulation! You are win!");
        return newrecord;
    }

    @Override
    public boolean playNext() {
        if (phList.isEmpty()){
            return false;
        }
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want to play it? Yes/No");
            String answer = scanner.next();
//            while (answer.equals("Yes") && answer.equals("No")) {
//                System.out.println("Do you want to play more? Yes/No");
//                answer = scanner.next();
//            }
            if (answer.equals("Yes")) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        WheelOfFurtune UserGame = new WheelOfFortuneUserGame("phrases.txt");
        AllGameRecord record = UserGame.playAll();
        System.out.println(record);
        System.out.println(record.highGameList(2));
        System.out.println(record.average());
    }
}
