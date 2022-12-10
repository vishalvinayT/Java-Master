

class polymorphism{
    public static void main(String[] args){
        CarPolymorphism myCar=getCar("audi");
        CarPolymorphism myCar2=getCar("bmw");
        CarPolymorphism mycar3=getCar("benz");
        CarPolymorphism myCar4=getCar("shdjh");

        System.out.println(mycar3.accelarate());
        System.out.println(myCar2.brake());
        System.out.println(myCar4.startEngine());
        System.out.println(myCar.startEngine());


    }

    public static CarPolymorphism getCar(String name){
        switch(name){
            case "benz":
                return  new benz();
            case "bmw":
                return new bwm();
            case "audi":
                return new audi();

            default:
                return new CarPolymorphism(0,"not a car");
        }
    }
}



public class CarPolymorphism {
    private boolean engine;
    private int cylinders;
    private int wheels;
    private String name;

    public CarPolymorphism(int cylinders, String name){
        this.wheels=4;
        this.cylinders=cylinders;
        this.name=name;
        this.engine=true;
    }
    public String startEngine(){
        return "Car -> startEngine()";
    }
    public String accelarate(){
        return "Car -> accelerate()";
    }
    public String brake(){
        return "Car -> brake()";
    }
    public int getCylinders(){
        return this.cylinders;
    }
    public String getName(){
        return this.name;
    }



}


class benz extends CarPolymorphism{
    public benz(){
        super(4,"benz");
    }

    @Override
    public String startEngine(){
        return "Benz Car Strated";
    }

    @Override
    public  String accelarate(){
        return "Benz Car Accelarated";
    }

    @Override
    public String brake(){
        return "Benz Car brake Applied";
    }
}



class bwm extends CarPolymorphism{
    public bwm(){
        super(12,"bmw");
    }

    @Override
    public String startEngine(){
        return "bmw Car Strated";
    }

    @Override
    public  String accelarate(){
        return "bmw Car Accelarated";
    }

    @Override
    public String brake(){
        return "bmw Car brake Applied";
    }
}



class audi extends CarPolymorphism{
    public audi(){
        super(8,"audi");
    }

    @Override
    public String startEngine(){
        return "audi Car Strated";
    }

    @Override
    public  String accelarate(){
        return "audi Car Accelarated";
    }

    @Override
    public String brake(){
        return "audi Car brake Applied";
    }
}