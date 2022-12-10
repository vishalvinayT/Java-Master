public class HealthyBurger extends Hamburger{
    private double price;
    private int count;
    private double addonsPrice;

    public HealthyBurger(){
        super("RyeBread","Beef");
        this.addonsPrice=0;
        System.out.println("Additional Items Available for Healthy Burger: Corn, extraSalad, egg");
    }

    @Override
    public void setBaseprice(){
        this.price=super.getBaseprice()+50;
    }

    @Override
    public double getBaseprice(){
        return this.price;
    }

    public int getCount(){
        return  this.count+super.getCount();
    }

    @Override
    public double getAddonsPrice(){
        double aprice=super.getAddonsPrice()+this.addonsPrice;
        return aprice;
    }


    public double getTotalPrice(){
        return this.price+this.getAddonsPrice();
    }
    @Override
    public double add(String name){
        super.add(name);
        while (this.count<=2){
            switch (name.toLowerCase()){
                case "corn":
                    System.out.println("Corn added");
                    this.addonsPrice+=40;
                    this.count++;
                    break;
                case "extrasalad":
                    System.out.println("Extra Salad added");
                    this.count++;
                    this.addonsPrice+=50;
                    break;
                case "egg":
                    System.out.println("Eggs added");
                    this.count++;
                    this.addonsPrice+=25;
                default:
                    System.out.println("Select given addons");
                    break;
            }
            break;
        }
        if(getCount()>6){
            System.out.println("Cant add more than six items");
            return this.addonsPrice;
        }
        else{
            return this.addonsPrice;
        }
    }
}
