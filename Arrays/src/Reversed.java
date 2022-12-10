public class Reversed {
    public static void reverse(int[] array){
      int temp;
      int c=1;
      for(int i=0;i<array.length/2;i++){
          temp=array[i];
          array[i]=array[array.length-c];
          array[array.length-c]=temp;
          c++;
      }
    }
}
