package quicksort;

public class QuickSort {
    public static void main(String[] args){
        int[] array= new int[]{2,31,4,7,1};
        quicksort(array,0,array.length-1);
        System.out.println(array.toString());
    }
    public static void quicksort(int[] array,int low, int high){
        if(array!=null){
            if(low<high){
                int partitionIndex=partition(array,low,high);
                quicksort(array,low,partitionIndex-1);
                quicksort(array,partitionIndex+1,high);
            }
        }
    }

    public static int partition(int[] array, int low,int high){
        if(array!=null) {
            int pivot = array[low];
            int i = low + 1;
            int j = high;
            do{

                while ( i < high-1) {
                    if(array[i]>=pivot){
                        break;
                    }
                    i++;
                }
                while ( j > low) {
                    if(array[j]<pivot){
                        break;
                    }
                    j--;
                }
                if (i < j) {
                    int c = array[i];
                    array[i] = array[j];
                    array[j] = c;
                }
            }while (i<j);

            int temp= array[low];
            array[low]=array[j];
            array[j]=temp;
            return j;

        }
        return -1;
    }
}
