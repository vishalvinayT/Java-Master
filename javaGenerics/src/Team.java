public class Team<T> {
    private String name;
    private int points;
    public Team(String name, int points){
        this.name=name;
        this.points=points;
    }
    public String getName(){
        return this.name;
    }
    public int getPoints(){
        return  this.points;
    }
    public void setPoints(int points){
        this.points=points;
    }

    public int getRanking(){
        return this.points*2+10;
    }
}
