public class Main {
    public static void main(String[] args) {
        int[] arr={1,4,12,0,35,231,312,-9,13,11};
        int[] binarr={1,4,6,78,99,145,176,200};
        int b=binarySearch(binarr,6);
        if(b>=0){
            System.out.println("binary search element found at "+b);
        }
        int l=linearSearch(arr,13);
        if(l>=0){
            System.out.println("linear search element found at "+l);
        }
    }

    public static int linearSearch(int[] array, int element){
        if(array!=null){
            for(int i=0;i<array.length;i++){
                if(array[i]==element){
                    return i;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    public static int binarySearch(int[] array, int element){
        int high=array.length-1;
        int low=0;
        int mid=0;
        if(high==element){
            return high;
        } else if (low==element) {
            return low;
        }
        else {
            while(low<=high){
                mid=(low+high)/2;
                if(array[mid]==element){
                    return mid;
                }
                if(element>array[mid]){
                    low=mid;
                }
                if(element<array[mid]){
                    high=mid;
                }
            }
        }

        return Integer.MIN_VALUE;
    }
}