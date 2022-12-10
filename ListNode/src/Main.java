import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        ListNode l1= new ListNode(7);
//        ListNode dum=l1;
//        l1.next=new ListNode(0);
//        dum=l1.next;
//        dum.next=new ListNode(5);
//
//
//
//        ListNode l2= new ListNode(3);
//        ListNode dum2=l2;
//        l2.next=new ListNode(2);
//        dum2=l2.next;
//        dum2.next=new ListNode(4);
//
//
//
//        Solution mysol=new Solution();
//        ListNode finalsol=mysol.addTwoNumbers(l1,l2);
//        while(finalsol!=null){
//            System.out.println(finalsol.val);
//            finalsol=finalsol.next;
//        }

        SolutionTemp sol=new SolutionOther();
        String a=sol.longestPalindrome("mymadamnew");
        System.out.println(a);

    }

}
class SolutionTemp {
    public String longestPalindrome(String s) {
        String[] mystr=s.split("");
        List<String> mylst=new ArrayList<String>();
        String correctString=mystr[0];
        for(int i=0;i<mystr.length;i++){
            String temp=mystr[i];
            for(int j=i+1;j<mystr.length;j++){
                temp+=mystr[j];
                if(temp.equals(reverseString(temp))){
                    correctString=temp;
                }
            }
        }
        return correctString;
    }

    private String reverseString(String a){
        String[] revstr=a.split("");
        String rev="";
        for(int i=revstr.length-1;i>=0;i--){
            rev+=revstr[i];
        }
        return rev;
    }
    public String correctString(List<String> str){
        int length=0;
        String a="";
        for(String s:str){
            if(s.length()>length){
                length=s.length();
                a=s;
            }
        }
        return a;
    }
}

class SolutionOther extends SolutionTemp {
    public String longestPalindrome(String s) {
        int start=0;
        int end=0;
        int low,high;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            low=i;
            high=i+1;

            while(low>=0 && high<n && s.charAt(low)==s.charAt(high))
            {
                if((end-start)<(high-low))
                {
                    start=low;
                    end=high;
                }
                low--;
                high++;
            }

            low=i;
            high=i+2;
            while(low>=0 && high<n && s.charAt(low)==s.charAt(high))
            {
                if((end-start)<(high-low))
                {
                    start=low;
                    end=high;
                }
                low--;
                high++;
            }
        }
        return s.substring(start,end+1);
    }
}