package mathpackage;

public class Series {
    public static int nSum(int n){
        int sum=0;
        for(int i=0;i<=n;i++){
            sum+=i;
        }
        return sum;
    }

    public static int factorial(int n){
        if(n>=1){
            int factorial =n * factorial(n-1);
            return factorial;
        }
        else{
            return 1;
        }
    }


    public static int fibonacii(int n){
        int a=0;
        int b=1;
        int c=0;
        for (int i=1;i<n;i++){
            c=a+b;
            a=b;
            b=c;

        }
        return c;
    }
}
