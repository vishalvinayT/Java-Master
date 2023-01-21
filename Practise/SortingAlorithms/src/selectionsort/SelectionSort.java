package selectionsort;

import Utililities.Utils;

public class SelectionSort {

    public static void main(String[] args){
        int[] array= new int[]{12,24,3,42,5,43,44,5,7,3453,12,121,2,121,121,2,2};
        Utils.traverseArray(array);
        selectionSort(array);
        Utils.traverseArray(array);
    }

    public static void selectionSort(int[] array){
        if(array!=null){
            int n= array.length;
            for(int i=0; i<n-1;i++){
                int minValueIndex= i;
                for(int j=i+1;j<n;j++){
                    if(array[j]< array[minValueIndex]){
                        minValueIndex=j;
                    }
                }
                int temp=array[i];
                array[i]=array[minValueIndex];
                array[minValueIndex]=temp;
            }
        }
    }
}
