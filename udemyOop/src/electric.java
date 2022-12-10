public class electric {
    public  int blub;
    private int heater;
    public int window;
    public room myroom;
    public electric(room room){
        this.myroom=room;
        System.out.println("My room consists of " + this.blub+" ,"+this.heater+","+this.window );
    }
    public int  getBulbpos(){
        return this.myroom.getWidth()/3;
    }
    public int getHeater(){
        return this.myroom.getArea()/34;

    }
    public int getWindow(){
        return this.myroom.getHeight()/2;
    }


}
