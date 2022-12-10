

public class Hamburger {
    private String rollType;
    private String meat;
    private double Baseprice;
    private double addonsPrice;
    private int count;
    public Hamburger(String roll, String meat){
        this.rollType=roll;
        this.meat=meat;
        System.out.println("Additional Items Available: Tomatoes, Onions, lettuce, carrot, salad");
    }
    public void setBaseprice(){
        this.Baseprice=150;
    }
    public void setAddonsPrice(){
        this.addonsPrice=0;
    }

    public void setCount(){
        this.count=0;
    }
    public double getBaseprice() {
        return this.Baseprice;
    }
    public double getAddonsPrice(){
        return this.addonsPrice;
    }
    public String getRollType(){
        return this.rollType;
    }
    public String getMeat(){
        return this.meat;
    }
    public int getCount(){
        return this.count;
    }

    public double getTotalPrice(){
        return this.Baseprice+this.addonsPrice;
    }

    public double add(String name){
        while(this.count<4){
            switch(name.toLowerCase()){
                case "tomatoes":
                    System.out.println("Tomatoes added");
                    this.count++;
                    this.addonsPrice+=20;
                    break;
                case "onions":
                    System.out.println("Onions added");
                    this.count++;
                    this.addonsPrice+=20;
                    break;
                case "carrot":
                    System.out.println("Carrot added");
                    this.count++;
                    this.addonsPrice+=20;
                    break;
                case "lettuce":
                    System.out.println("Lettuce added");
                    this.count++;
                    this.addonsPrice+=30;
                    break;
                case "salad":
                    System.out.println("Salad added");
                    this.count++;
                    this.addonsPrice+=25;
                    break;
                default:
                    System.out.println("Select given addons");
                    break;
            }
            break;
        }
        if(this.getCount()>4){
            System.out.println("Cant add more than four items");
            return this.addonsPrice;
        }
        else{
            return this.addonsPrice;
        }
    }


}
