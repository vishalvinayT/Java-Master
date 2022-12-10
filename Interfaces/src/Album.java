import java.util.LinkedList;
import java.util.ArrayList;

public class Album {
    private String name;
    private String artist;
    SongList songs= new SongList();
    public Album(String name, String artist){
        this.name=name;
        this.artist=artist;
    }

    public boolean addSong(String title, double duration){
        return songs.add(title,duration);
    }

    public boolean addToPlayList(int track, LinkedList<Song> playList){
        Song song=this.songs.findSong(track);
        if(song!=null){
            playList.add(song);
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList){
        Song song=this.songs.findSong(title);
        if(song!=null){
            playList.add(song);
            return true;
        }
        return false;
    }





    private class SongList {
        ArrayList<Song> songs;
        public SongList(){
            this.songs=new ArrayList<>();
        }

        public boolean add(String name, double duration){
            Song song=findSong(name);
            if(song==null){
                songs.add(song);
                return true;
            }
            return false;
        }

        private Song findSong(String title){
            for(int i=0;i<this.songs.size();i++){
                Song song=songs.get(i);
                if(song.getName().equals(title)){
                    return song;
                }
            }
            return  null;
        }

        private Song findSong(int track){
            int i=track-1;
            if(i>=0 && i<=this.songs.size()){
                Song song=songs.get(i);
                return song;
            }
            return null;
        }
    }
}
