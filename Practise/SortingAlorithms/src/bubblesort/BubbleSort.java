package bubblesort;
import Utililities.Utils;


public class BubbleSort {
    public static void main(String[] args){
        int[] array= new int[]{0,1,2,3,5};
        Utils.traverseArray(array);
        bubbleSort(array);
        Utils.traverseArray(array);

    }


    public static void bubbleSort(int[] array){
        if(array!=null){
            int n=array.length;
            boolean isSorted= false;
            for(int i=0; i<n-1;i++){
                isSorted=true;
                for(int j=0; j<n-1-i;j++){
                    if(array[j]>array[j+1]){
                        isSorted=false;
                        int temp=array[j];
                        array[j]=array[j+1];
                        array[j+1]=temp;
                    }
                }
                if(isSorted){
                    return;
                }
            }
        }
    }

}
