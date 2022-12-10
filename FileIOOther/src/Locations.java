import java.io.*;
import java.security.KeyStore;
import java.util.*;


public class Locations implements Map<Integer ,Location> {

    public static void main(String[] args)  {

        // writting an 2D array
//        short[][] arr={{2,3,4,5},{3,4,6,8},{0,0,0,0},{255,155,255,255}};
//        try (ObjectOutputStream file=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("D:\\Java\\FileIOOther\\matrix.data")))){
//            file.writeObject(arr);
//            System.out.println("Done");
//        }catch (IOException e){
//              e.printStackTrace();
//        }

//        try (ObjectOutputStream file=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("D:\\Java\\FileIOOther\\Seriallocations.data")))){
//            for(Location loc: locations.values()){
//                file.writeObject((Location) loc);
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        try(DataOutputStream files=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("D:\\Java\\FileIOOther\\locations.data")))){
//            for (Location loc : locations.values()){
//                System.out.println(loc.getDirection()+"--->"+loc.getDescription());
//                files.writeInt(loc.getDirection());
//                files.writeUTF(loc.getDescription());
//                DataOutputStream exits=null;
//                try{
//                   exits =new DataOutputStream(new BufferedOutputStream(new FileOutputStream("D:\\Java\\FileIOOther\\exits.data")));
//                    for (String loc1:loc.getExits().keySet()){
//                        System.out.println(loc1+"--->"+loc.getExits().get(loc1));
//                        exits.writeUTF(loc1);
//                        exits.writeInt(loc.getExits().get(loc1));
//                    }
//                }catch (IOException a){
//                    a.getMessage();
//                }
//                finally {
//                    if(exits!=null){
//                        exits.close();
//                    }
//                }
//            }
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }

    }
    private static Map<Integer,Location> locations=new HashMap<>();
    static{
        // reading an array
        try(ObjectInputStream file=new ObjectInputStream(new BufferedInputStream(new FileInputStream("D:\\Java\\FileIOOther\\matrix.data")))){
            boolean eof=false;
            while(!eof){
                try{
                    short[][] arr= (short[][]) file.readObject();
                    for(int i=0;i< arr.length;i++){
                        for (int j=0;j<arr[0].length;j++){
                            System.out.print(arr[i][j]+"\t");
                        }
                        System.out.println();
                    }
                }catch (EOFException a){
                    a.getMessage();
                    eof=true;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }


//        try(ObjectInputStream file=new ObjectInputStream(new BufferedInputStream(new FileInputStream("D:\\Java\\FileIOOther\\Seriallocations.data")))){
//            boolean eof=false;
//            while(!eof){
//                try{
//                    Location location=(Location) file.readObject();
//                    locations.put(location.getDirection(),location);
//                    System.out.println("Done " +location.getDirection()+"----->"+location.getDescription());
//                }catch (EOFException a){
//                    a.getMessage();
//                    eof=true;
//                } catch (ClassNotFoundException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }

//        try(DataInputStream file=new DataInputStream(new BufferedInputStream(new FileInputStream("D:\\Java\\FileIOOther\\locations.data")))){
//            boolean eof=false;
//            while(!eof){
//                try {
//                    int loc = file.readInt();
//                    String des=file.readUTF();
//                    System.out.println("Imported "+loc+"--->"+des);
//                    locations.put(loc,new Location(loc,des,null));
//                }catch (EOFException e){
//                    eof=true;
//                }
//            }
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        DataInputStream file=null;
//        try{
//             file=new DataInputStream(new BufferedInputStream(new FileInputStream("D:\\Java\\FileIOOther\\exits.data")));
//            String direc=file.readUTF();
//            int loc=file.readInt();
//            System.out.println("Imported "+direc+"---->"+loc);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        finally {
//            if(file!=null){
//                try {
//                    file.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
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
