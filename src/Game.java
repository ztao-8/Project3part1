public abstract class Game {
    public AllGameRecord playAll(){
        AllGameRecord allrecords  = new AllGameRecord();
        while (playNext()){
            GameRecord record = play();
            allrecords.add(record);
        }
        return allrecords;
    }
    public abstract GameRecord play();
    public abstract boolean playNext();
}
