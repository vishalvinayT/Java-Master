import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Solution sol=new Solution();
        List<String> finalStr=sol.letterCombinations("23");
        for(String str: finalStr){
            System.out.println(str);
        }

    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinedList=new ArrayList<>();
        String digi=filterString(digits);
        if(digi.isEmpty()){
            return combinedList;
        }
        else{
            Map<Integer, String[]> mapNums= new HashMap<>(this.mapNums());
            List<String> stack=new ArrayList<>();
            stack.add("");
            String[] keys=digi.split("");
            int length=keys.length;
            for(int i=0;i<length;i++){
                List<String> temp= new ArrayList<>();
                for(int k=stack.size()-1;k>=0;k--){
                    String[] arr=mapNums.get(Integer.parseInt(keys[i]));
                    String stackVal=stack.get(k);
                    temp.addAll(this.addVals(stackVal, arr, combinedList,length));
                }
                stack.addAll(temp);
            }
            return combinedList;
        }
    }

    public String filterString(String str) {
        String sample="";
        String reg = "([2-9]+)";
        Pattern pat = Pattern.compile(reg);
        Matcher matcher = pat.matcher(str);
        while(matcher.find()){
            sample=matcher.group(1);
        }
        return sample;
    }




    public List<String> addVals(String stackVal, String[] arr, List<String> finalList, int length){
        String val;
        List<String> temp=new ArrayList<>();
        for(String i: arr){
            val=stackVal+i;
            temp.add(val);
            if(val.length()==length){
                finalList.add(val);
            }
        }
        return temp;
    }

    public Map<Integer,String[]> mapNums(){
        Map<Integer,String[]> intStrings=new HashMap<>();
        String[] a={"a","b","c"};
        String[] b={"d","e","f"};
        String[] c={"g","h","i"};
        String[] d={"j","k","l"};
        String[] e={"m","n","o"};
        String[] f={"p","q","r","s"};
        String[] g={"t","u","v"};
        String[] h={"w","x","y","z"};

        intStrings.put(2,a);
        intStrings.put(3,b);
        intStrings.put(4,c);
        intStrings.put(5,d);
        intStrings.put(6,e);
        intStrings.put(7,f);
        intStrings.put(8,g);
        intStrings.put(9,h);

        return intStrings;
    }
}