package countsort;
import Utililities.Utils;

public class CountSort {
    public static void main(String[] args){
        int[] array= new int[]{3,1,9,7,1,2,4,123,44,66,11,12,11,11};
        Utils.traverseArray(countSort(array));
    }
    public static int[] countSort(int[] array){
        if(array!=null){
            int max=Integer.MIN_VALUE;
            for(int i=0; i<array.length; i++){
                max=Math.max(max,array[i]);
            }
            int finalArrSize=0;
            int[] count_array=new int[max+1];
            for(int i=0; i<array.length;i++){
                count_array[array[i]]+=1;
                finalArrSize+=1;
            }
            int[] final_array=new int[finalArrSize];
            int incrementer=0;
            for(int i=0; i<count_array.length; i++){
                while(count_array[i]>0){
                    final_array[incrementer]=i;
                    count_array[i]-=1;
                    incrementer++;
                }
            }
            return final_array;
        }
        return null;
    }
}
