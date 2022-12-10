import java.util.Scanner;

public class arraySort {

    public int[] getIntegers(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Number of Integers \r");
        int myint=scanner.nextInt();
        int[] myarray=new int[myint];
        for(int i=0;i<myint;i++){
            System.out.println("Enter the element \r");
            myarray[i]=scanner.nextInt();
        }
        return myarray;
    }
    public void printArray(int[] array){

        for(int i=0;i<array.length;i++){
            System.out.println("The "+ i+" element"+array[i]);
        }
    }

    public int[] sortArray(int[] array) {
        int temp=0;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                if(array[i]>array[j]){
                    temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }
}
