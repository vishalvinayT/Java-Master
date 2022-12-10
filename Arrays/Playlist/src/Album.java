import java.util.ArrayList;

public class Album {
    private String name;
    private ArrayList<Song> songs;
    public Album(String name){
        this.name=name;
        this.songs=new ArrayList<Song>();
    }
    public String getName(){
        return this.name;
    }

    public ArrayList<Song> getSongs(){
        return this.songs;
    }
    public boolean addSong(String name, double duration){
        Song song=findSong(name);
        if(song==null){
            songs.add(new Song(name,duration ));
            return true;
        }
        return false;
    }

    private Song findSong(String name){
        for(int i=0;i<songs.size();i++){
            Song song=songs.get(i);
            if(song.getName().equals(name)){
                return song;
            }
        }
        return null;
    }
}
