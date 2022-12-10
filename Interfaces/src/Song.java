public class Song {
    private String name;
    private double duration;
    public Song(String name, double duration){
        this.name=name;
        this.duration=duration;
    }

    public String getName(){
        return this.name;
    }

    public double getDuration(){
        return this.duration;
    }
}
