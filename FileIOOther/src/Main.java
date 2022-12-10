
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Locations locations=new Locations();
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