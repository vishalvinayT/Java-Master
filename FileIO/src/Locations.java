import java.io.*;
import java.security.KeyStore;
import java.util.*;


public class Locations implements Map<Integer ,Location> {

    public static void main(String[] args) throws Exception{
//        FileWriter file=null;
//        try{
//            file=new FileWriter("D:\\Java\\FileIO\\writer.txt");
//            for (Map.Entry<Integer,Location> item:locations.entrySet()) {
//                file.write(item.getValue().getDirection()+", "+item.getValue().getDescription()+"\n");
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        finally{
//         if(file!=null){
//             file.close();
//         }
//        }
    }
    private static Map<Integer,Location> locations=new HashMap<>();
    static{
        // read Locations
        try(Scanner scanner= new Scanner(new BufferedReader(new FileReader("D:\\Java\\FileIO\\GameData\\locations_big.txt")))){
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()){
                int loc=Integer.parseInt(scanner.next());
                scanner.skip(scanner.delimiter());
                String descrip=scanner.nextLine();
                Map<String,Integer> items=new HashMap<>();
                locations.put(loc, new Location(loc, descrip, items));
            }
        }catch (IOException e){
            System.out.println("OOPs");
            e.printStackTrace();
        }

        try (BufferedReader file=new BufferedReader(new FileReader("D:\\Java\\FileIO\\GameData\\directions_big.txt"))){
            while (true){
                String input=file.readLine();
                if(input==null){
                    System.out.println();
                    break;
                }
                String[] params=input.split(",");
                int loc=Integer.parseInt(params[0]);
                String desc=params[1];
                int des=Integer.parseInt(params[2]);
                Location location=locations.get(loc);
                location.addExits(desc,des);

            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public Locations(){
        super();
    }


    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }


    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }


    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }


    @Override
    public Location get(Object key) {
        return locations.get(key);
    }


    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }


    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }


    @Override
    public void clear() {

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }


    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
