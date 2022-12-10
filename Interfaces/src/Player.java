import java.util.ArrayList;
import java.util.List;

public class Player implements Savable{
    private int points;
    private String name;
    private String Weapon;
    private int hitPoints;

    public Player(String name, int points,int hitpoints){
        this.name =name;
        this.Weapon="gun";
        this.hitPoints=hitpoints;
        this.points=points;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public String getWeapon() {
        return Weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public List<String> write(){
        List<String> list=new ArrayList<>();
        list.add(""+this.name);
        list.add(""+this.points);
        list.add(""+this.hitPoints);
        list.add(""+this.Weapon);

        return list;
    }

    @Override
    public void read(List<String> values){
        if(values.size()>0 && values!=null){
            for(String i: values){
                System.out.println(""+i);
            }
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "points=" + points +
                ", name='" + name + '\'' +
                ", Weapon='" + Weapon + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }
}



