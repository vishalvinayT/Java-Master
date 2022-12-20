public class Main {
    public static void main(String[] args) {
        int[] array=new int[100];
        array[0]=1;array[1]=4;array[2]=6;array[3]=10;array[4]=15;array[5]=45;array[6]=56;array[7]=65;
        int size=8;
        traversal(array,8);
        insert(array,-8,100,8,0);
        traversal(array,9);
        delete(array,0,9,100);
        traversal(array,8);
    }

    public static void traversal(int[] array, int size){
        for(int i=0;i<size;i++){
            System.out.format("%d ",array[i]);
        }
        System.out.println();
    }

    public static void delete(int[] array,int index, int size, int capacity){
        if(size>capacity || size<0 || capacity<0 || index<0){
            return;
        }
        for(int i=index;i<=size-1;i++){
            array[i]=array[i+1];
        }

    }

    public static void insert( int[] array,int element,int capacity, int size, int index){
        if(size>=capacity || array==null || capacity<0 || size<0 || index<0){
            return;
        }
        for(int i=size-1;i>=index;i--){
            array[i+1]=array[i];
        }
        array[index]=element;
    }
}