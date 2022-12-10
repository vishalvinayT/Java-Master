import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Savable player;
        player=new Player("vis",100,10);
        writeObject(player);
        readObject(player);

    }
    public static void writeObject(Savable savable){
        for (String i:
             savable.write()) {
            System.out.println("Saving "+i);
        }
    }
    public static List<String> readvalues(){
        List<String> values=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        boolean quit=false;
        int index=0;
        while (!quit){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Quitted");
                    quit=true;
                    break;
                case 2:
                    String name =scanner.nextLine();
                    values.add(index,name);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void readObject(Savable savable){
        List<String> list= readvalues();
        savable.read(list);

    }
}