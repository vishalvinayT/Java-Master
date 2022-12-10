public class furniture {
    private int sofa;
    private int bed;
    public electric myelectric;
    public furniture(electric electric){
        this.myelectric=electric;

    }
    public int getSofa(){
        return this.myelectric.window-2;
    }
    public int getbed(){
        return this.myelectric.getBulbpos();
    }
}
