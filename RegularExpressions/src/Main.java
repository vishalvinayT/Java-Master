import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String s1="I Want a Bike.";
        String s2="I Want a Ball.";
        String reg="^(?i)[i want a ](.*.$)";
//        System.out.println(s1.matches(reg));
//        System.out.println(s2.matches(reg));

        Pattern pattern=Pattern.compile(reg);
        Matcher matcher= pattern.matcher(s1);
        Matcher matcher2= pattern.matcher(s2);
//        System.out.println(matcher.matches());
//        System.out.println(matcher2.matches());

        String txt="Replace all Blanks with UnderScore";
        //System.out.println(txt.replaceAll("\\s","_"));


        String str="aaabccccccccdddefffg";
        //System.out.println(str.matches("^(?i)a.*g$"));


        String chall7="abcd.123";
        String r1="(?i)\\S+^\\.\\d+$";
        //System.out.println(chall7.replaceAll(r1,"a"));
        Pattern pat=Pattern.compile(r1);
        Matcher mat=pat.matcher(chall7);
        mat.find();
        //System.out.println(mat.group(1));

        String chall8="abcd.135uvqz.7tzik.999";
        String chall9="abcd.135\tuvqz.7\ttzik.999\n";
        String reg9="[A-Za-z]+\\.(\\d+)";
        String reg8="(\\d+)";
        Pattern pattern1=Pattern.compile(reg8);
        Matcher mat8=pattern1.matcher(chall9);
        while(mat8.find()){

            // for reg9 in a group use:
            //System.out.println("Start: "+ mat8.start(1)+" End: "+mat8.end(1));
//            System.out.println("Start: "+ mat8.start()+" End: "+mat8.end());
//            System.out.println(mat8.group(1));
        }


        String chall11="{0,2},{0,5},{1,3}, {2,4}";
        String reg11="\\w+";
        // String reg11="\\{(.+?)\\}"
        //System.out.println(chall11.replaceAll(reg11,"a"));


        String chall12="11111";
        String reg12="^\\d{5}$";
//        System.out.println(chall12.matches(reg12));


        String chall13="11111-1111";
        String reg13="^\\d{5}-\\d{4}$";
        //System.out.println(chall13.matches(reg13));

        String chall14="11111-1111";
        String reg14="^\\d{5}(-\\d{4})?";
        System.out.println(chall14.matches(reg14));
    }
}