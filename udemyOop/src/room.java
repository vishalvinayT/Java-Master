public class room {
    public int width;
    public int length;
    public int height;
    public room(int width, int length, int height ){
        this.width=width;
        this.length=length;
        this.height=height;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }
    public int getArea(){
        return this.width*this.height;
    }
    public int getVolume(){
        return getArea()*this.height;
    }
}
