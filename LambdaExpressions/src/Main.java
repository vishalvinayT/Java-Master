import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Employees john=new Employees("John Greesham ",20);
        Employees emma=new Employees("Emma Watson ",25);
        Employees kay=new Employees("Kay Upek ",25);
        Employees elon=new Employees("Elon Musk",40);
        Employees jack=new Employees("Jack Gill",50);

        List<Employees> emp=new ArrayList<Employees>();
        emp.add(john);
        emp.add(emma);
        emp.add(kay);
        emp.add(elon);
        emp.add(jack);

        //todo use predicates
        Predicate<Employees> emp1=(Employees e) -> e.getAge()>25;
        Predicate<Employees> emp2=(Employees e) -> e.getAge()<=50;

        Predicate chained=emp1.and(emp2);

        for(Employees employee: emp){
            if (chained.test(employee)) {
                System.out.printf("The employee name is %s and emp age is %d",employee.getName(),employee.getAge());
                System.out.println();
            }
        }

        // todo implement function to get Last name for employees

        Function<Employees, String> getlast= (Employees femp)-> femp.getName().substring(femp.getName().indexOf(" "));
        Function<String,String> concatlast=(String name) -> name+"    @Vishal";

        Function chainedFunc=getlast.andThen(concatlast);

        for(Employees employee:emp){
            System.out.println(chainedFunc.apply(employee));
        }

        // todo BiFunction

        BiFunction<String, Employees, String> biemp=(String name, Employees employee) -> {
            String finalStr=name + " --->" +getlast.apply(employee);
            return finalStr;
        };

        for (Employees empl:emp){
            System.out.println(biemp.apply("Google",empl));
        }





//        Comparator<Employees> c=(e1,e2)-> e1.getName().compareTo(e2.getName());
//        Collections.sort(emp, (Employees e1,Employees e2) -> {
//            int a=e1.getName().compareTo(e2.getName());
//            return a;
//                }
//          );
//
//        for(Employees e: emp){
//            System.out.println(e.getName());
//        }
    }
}

