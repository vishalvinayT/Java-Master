package Utililities;

public class Utils {


    public static void traverseArray(int[] array){
        if(array!=null){
            for(int i: array){
                System.out.printf("%4d  ",i);
            }
            System.out.println();
        }

    }
}
