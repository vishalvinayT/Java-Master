import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class League<T extends Team> implements Ileague {
    private String name;
    ArrayList<T> teamsList= new ArrayList<T>();
    public League(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }


    public boolean addTeam(T team){
        if(teamsList.contains(team)){
            System.out.println("Team is present");
            return false;
        }
        else{
            teamsList.add(team);
            return true;
        }
    }

    @Override
    public void table(){
        Collections.sort(teamsList, Comparator.comparing(Team::getRanking));
        for(Team<T> team:teamsList ){
            System.out.println(team.getName()+" and Ranking -->"+team.getRanking());
        }
    }
}
