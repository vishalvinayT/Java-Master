import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Runnable r= ()->{
            String myString="Lets Split this up into an array";
            String[] arr=myString.split(" ");
            for(String i: arr){
                System.out.println(i);
            }
        };
        Function<String,String> a=(String source) -> {
            StringBuilder ret=new StringBuilder();
            for(int i=0;i<source.length();i++){
                if(i%2==1){
                    ret.append(source.charAt(i));
                }
            }
            return ret.toString();
        };

        //everySecondCharecter(a,"1234567890");

        Supplier<String> sup=() -> "I Love Java ";

        String mystr=sup.get();
        //System.out.println(mystr);
        List<String> topName2015= Arrays.asList("Amelia","Olivia","emily","Isla","Ava","oliver","Jack","Charlie","harry","Jacob");
        Function<String,String> title=s -> {
            char chr=Character.toUpperCase(s.charAt(0));
            String str=s.substring(1,s.length());
            return chr+str;
        };

        Predicate<String> myfil=s -> s.startsWith("A");
        List<String> newlst=new ArrayList<>();
        for (String str: topName2015){
            newlst.add(title.apply(str));
        }
        Collections.sort(newlst,(e1,e2)-> e1.compareTo(e2));
        int count=0;
        for (String str: newlst){
            if(myfil.test(str)) count++;

        }
        System.out.println(count);



        long val=topName2015.stream().map(s -> Character.toUpperCase(s.charAt(0))+s.substring(1)).filter(s -> s.startsWith("A")).sorted().count();
        List<String> mylst=topName2015.stream().map(s -> Character.toUpperCase(s.charAt(0))+s.substring(1)).filter(s -> s.startsWith("A")).sorted().collect(Collectors.toList());
        mylst.forEach(System.out::println);
    }

    public static void everySecondCharecter(Function<String,String> myfunc, String s){
        System.out.println(myfunc.apply(s));
    }
}