public class vehicle {
    public  int wheels;
    private String type;
    private String fuel;
    private boolean hasStreeing;
    private String modeOFTransport;
    public  vehicle(int wheels, String type, String fuel, boolean steering, String transport){
        this.wheels=wheels;
        this.type=type;
        this.fuel=fuel;
        this.hasStreeing=steering;
        this.modeOFTransport=transport;
    }

    public void getVehilcle(){
        System.out.println("Hey your vehicle");
    }
}
