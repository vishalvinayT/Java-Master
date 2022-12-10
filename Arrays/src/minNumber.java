import java.util.Scanner;

public class minNumber {
    public static Scanner scanner=new Scanner(System.in);
    public int[] readIntegers(int count){
        int[] array=new int[count];
        scanner.nextLine();
        for(int i=0;i<count;i++){
            array[i]=scanner.nextInt();
        }
        return array;
    }
    public int findMin(int[] array){
        boolean c=true;
        int temp;
        while(c){
            c=false;
            for(int i=0;i<array.length-1;i++){
                if(array[i]>array[i+1]){
                    temp=array[i];
                    array[i]=array[i+1];
                    array[i+1]=temp;
                    c=true;
                }
            }
        }
        return array[0];
    }
}
