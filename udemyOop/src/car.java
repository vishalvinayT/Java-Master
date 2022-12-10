public class car extends vehicle{
    private String typerOfCar;
    private String brand;
    public car(String fuel, String car, String brand){
        super(4,"car",fuel,true,"road"); // Super always first
        this.typerOfCar=car;
        this.brand=brand;

    }

    public void getCar(){
        super.getVehilcle();
        System.out.println("is of type Car");
        System.out.println("Hey this is "+this.typerOfCar);
    }
}
