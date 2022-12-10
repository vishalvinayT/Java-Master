public class Delux extends Hamburger{
    private double chipsPrice;
    private double drinksPrice;
    public Delux(String bread, String meat){
        super(bread, meat);
        System.out.println(" The default addons are : chips , drinks");
    }
    public double getChipsPrice(){
        return 100;
    }
    public double getDrinksPrice(){
        return 100;
    }
    public double getTotalPrice(){
        double totalPrice=super.getBaseprice()+this.getChipsPrice()+getDrinksPrice();
        return totalPrice;
    }
}
