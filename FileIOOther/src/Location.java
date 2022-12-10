import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Location implements Serializable {
    private int direction;
    private String description;
    public Map<String, Integer> exits;
    private final long serialVersionUID=1L;
    public Location(int direction, String description, Map<String,Integer> exits)  {
        this.direction=direction;
        this.description=description;
        if(exits!=null){
            this.exits=new HashMap<>(exits);
        }
        else{
            this.exits=new HashMap<String,Integer>();
        }
        this.exits.put("Q",0);
    }

    public int getDirection() {
        return direction;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }

    public boolean addExits(String description, int direction){
        if(description!=null ){
            this.exits.put(description,direction);
            return  true;
        }
        else{
            return false;
        }
    }
}
