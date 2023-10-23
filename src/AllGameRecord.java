import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllGameRecord {
    private List<GameRecord> record = new ArrayList<GameRecord>();

    public void add(GameRecord r){
        record.add(r);
    }
    public float average(){
        int total = 0;
        for (GameRecord r: record) {
            total += r.getScore();
        }
        return (float) total / record.size();
    }

    public float average(String playerId){
        int total = 0;
        int count = 0;
        for (GameRecord r: record) {
            if (r.getId() == playerId){
                total += r.getScore();
                count++;
            }
        }
        return (float) total / count;
    }

    public List<GameRecord> highGameList(int n){
        List<GameRecord> highlist  = new ArrayList<>(record);
        Collections.sort(highlist,Collections.reverseOrder());
        return highlist.subList(0, Math.min(n, highlist.size()));
    }

    public List<GameRecord> highGameList(String playerId, int n){
        List<GameRecord> highlist  = new ArrayList<>();
        for (GameRecord r: record) {
            if (r.getId() == playerId){
                highlist.add(r);
            }
        }
        Collections.sort(highlist,Collections.reverseOrder());
        return highlist.subList(0, Math.min(n, highlist.size()));
    }

    @Override
    public String toString() {
        return "AllGameRecord{" +
                "record=" + record +
                '}';
    }
}
