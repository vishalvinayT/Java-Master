public class Utilities {
    public  char[] everynthChar(char[] srcchar, int n){
        if(srcchar.length<n || srcchar==null){
            return srcchar;
        }
        int newLength=srcchar.length/n;
        char[] newChar=new char[newLength];
        int index=0;
        for(int i=n-1;i< srcchar.length;i+=n){
            newChar[index]=srcchar[i];
            index++;
        }
        return newChar;
    }

    public String removePairs(String src){
        if(src==null || src.length()<2){
            return src;
        }
        StringBuilder builder=new StringBuilder();
        char[] srcStr=src.toCharArray();
        for(int i=0;i<srcStr.length-1;i++){
            if(srcStr[i] != srcStr[i+1]){
                builder.append(srcStr[i]);
            }
        }
        builder.append(srcStr[srcStr.length-1]);
        return builder.toString();
    }


    public int converter(int a,int b){
        try{
            return  (a/b)+(a*30)-2;
        }
        catch (ArithmeticException e){
            throw  new ArithmeticException();
        }
    }

    public String nullIfOddLength(String s){
        if (s==null || s.length()%2==1){
            return null;
        }
        return s;
    }



}
