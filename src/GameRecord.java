public class GameRecord implements Comparable<GameRecord>{
    private int score;
    private String id;

    @Override
    public String toString() {
        return "GameRecord{" +
                "score=" + score +
                ", id='" + id + '\'' +
                '}';
    }

    public GameRecord(int score, String playerId) {
        this.score = score;
        this.id = playerId;
    }

    public int getScore() {
        return score;
    }

    public String getId() {
        return id;
    }

    public int compareTo(GameRecord other) {

        if (this.score == other.score) {
            return 0;
        } else {
            if (this.score>other.score) {
                return Math.round(this.score-other.score);
            } else {
                return -1;
            }
        }
    }
}
