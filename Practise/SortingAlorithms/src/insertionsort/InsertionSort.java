package insertionsort;


import Utililities.Utils;

public class InsertionSort {

    public static void main(String[] args){
        int[] array= new int[]{12,34,1,45,21,44,21,23,43,45,0};
        Utils.traverseArray(array);
        insertionSort(array);
        Utils.traverseArray(array);
    }

    public static void insertionSort(int[] array){
        if(array!=null){
            int n= array.length;
            for(int i=1; i<n; i++){
                int valueToInsert=array[i];
                int j=i-1;
                while((j>=0) && (array[j]> valueToInsert)){
                    int newVal=array[j];
                    array[j+1]=newVal;
                    j--;
                }
                array[j+1]=valueToInsert;
            }
        }
    }
}
