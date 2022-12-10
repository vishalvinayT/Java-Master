import java.awt.*;
import java.sql.SQLOutput;
import java.util.Locale;

public class suv extends car {
    private String color;
    private int milage;
    public suv(String color, String brand,int milage){
        super("petrol","Suv",brand);
        this.color=color;
        this.milage=milage;
    }

    public void getPrice(){
        super.getCar();
        if (this.color.toLowerCase()=="black" && this.milage==20){
            System.out.println("your Price is : 2500000");
        }
        else if(this.color=="white"&& this.milage==20){
            System.out.println("your price is : 2700000");
        }
        else{
            System.out.println(" your price is : 1800000");
        }
    }
}
