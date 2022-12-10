import java.util.ArrayList;
import java.util.LinkedList;

public class Playlist {
    private String name;
    private ArrayList<Album> albums;
    private LinkedList<Song> songs;
    public Playlist(String name){
        this.name=name;
        this.albums=new ArrayList<Album>();
        this.songs=new LinkedList<>();
        addAlbums();
    }
    public String getName(){
        return this.name;
    }
    public ArrayList<Album> getAlbums(){
        return this.albums;
    }

    public LinkedList<Song> getSongs(){
        return this.songs;
    }
    public boolean addSong(String albumName, String songName){
        Song check=ifSongExists(albumName,songName);
        if(check!=null){
            songs.add(check);
            return true;
        }
        return false;
    }

    private Song ifSongExists(String albumName, String Songname){
        Album check=ifAlbumExists(albumName);
        for(int i=0;i<check.getSongs().size();i++){
            Song song=check.getSongs().get(i);
            if(song.getName().equals(Songname)){
                return song;
            }
        }
        return null;
    }

    private Album ifAlbumExists(String name){
        for(int i=0;i<this.albums.size();i++){
            Album album=albums.get(i);
            if(album.getName().equals(name)){
                return album;
            }
        }
        return null;
    }


    public void addAlbums(){
        Album sham=new Album("Sham");
        sham.addSong("rathalu",3);
        sham.addSong("shambahi",5);
        sham.addSong("dead",4);
        albums.add(sham);

        Album bahu=new Album("Bahu");
        bahu.addSong("intro",2);
        bahu.addSong("fight",3);
        bahu.addSong("romance",4);
        albums.add(bahu);

        Album kgf=new Album("KGF");
        kgf.addSong("sentiment",3);
        kgf.addSong("toofan",5);
        albums.add(kgf);

    }

}
