
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Map<Integer,Location> locations=new HashMap<>();
        Map<String,Integer> items=new HashMap<String,Integer>();
        locations.put(0,new Location(0,"End", items));
        locations.put(5,new Location(5,"Forest",items));
        items=new HashMap<>();
        items.put("N",5);
        items.put("S",4);
        items.put("W",2);
        items.put("E",3);
        locations.put(1,new Location(1,"Room",items));
        items=new HashMap<>();
        items.put("N",5);
        items.put("S",4);
        locations.put(2,new Location(2,"Hill",items));
        items=new HashMap<>();
        items.put("W",1);
        locations.put(3,new Location(3,"Building",items));
        items=new HashMap<>();
        items.put("N",1);
        items.put("W",2);
        locations.put(4,new Location(4,"Valley",items));
        items=new HashMap<>();
        items.put("S",1);
        items.put("E",2);
        locations.put(4,new Location(4,"Valley",items));
        game(locations);
    }

    public static void game(Map<Integer,Location> locations){
        Map<String,String> vocabulary=new HashMap<>();
        vocabulary.put("EAST","E");
        vocabulary.put("WEST","W");
        vocabulary.put("NORTH","N");
        vocabulary.put("SOUTH","S");
        vocabulary.put("QUIT","Q");
        Scanner scanner= new Scanner(System.in);
        int loc=1;
        while (true){
            System.out.println(locations.get(loc).getDescription());
            if(loc==0){
                break;
            }
            else{
                Map<String, Integer> exits=locations.get(loc).getExits();
                System.out.print("Available exits are:");
                for(String direction: exits.keySet()){
                    System.out.print(direction+",");
                }
                System.out.println();
                String val=scanner.nextLine().toUpperCase();
                if(val.length()>1){
                    String[] w=val.split(" ");
                    for(String v:w ){
                        if(vocabulary.containsKey(v)){
                            val=vocabulary.get(v);
                        }
                    }
                }
                if(exits.containsKey(val)){
                    loc=exits.get(val);
                }
                else {
                    System.out.println("Cant go in the direction");
                }

            }

        }
    }
}