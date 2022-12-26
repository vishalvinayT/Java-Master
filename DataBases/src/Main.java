
import javax.xml.crypto.Data;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        String database="music.db";
//        DataSource dataSource= new DataSource(database);
        DataSource dataSource=DataSource.getInstance();
        dataSource.open();
//        List<Artists> artists=dataSource.getArrists();
//        if(artists!=null){
//            for(Artists ar:artists){
//                System.out.println("_id :"+ar.get_id()+" name:"+ar.getName());
//            }
//        }else{
//            System.out.println("No artists found ");
//        }

//        List<String> songs=dataSource.searchByArtists("Carole King", DataSource.ORDER_BY_DESC);
//        for(String song: songs){
//            System.out.println(song);
//        }

//        List<SongArtist> artists=dataSource.searchBySong("Your Time Is Gonna Come",DataSource.ORDER_BY_ASC);
//        for(SongArtist sa: artists){
//            System.out.println("Artist name : "+ sa.getArtistName()+" Album name: "+ sa.getAlbumName()+" track: "+ sa.getTrack());
//        }

       // dataSource.getSongCount();

        //dataSource.createViewArrtists();
//        List<SongArtist> songArtists=dataSource.viewArtists();
//        for(SongArtist sa: songArtists){
//            System.out.println("Artist name: "+ sa.getArtistName()+" Album name: "+ sa.getAlbumName()+" track: "+sa.getTrack());
//        }

//
//
//        List<SongArtist> sArtists=dataSource.searchBySong_ph("Your Time Is Gonna Come");
//        for(SongArtist sa: sArtists){
//            System.out.println("Artist name: "+ sa.getArtistName()+" Album name: "+ sa.getAlbumName()+" track: "+sa.getTrack());
//        }
//
        InsertSong song=new InsertSong(dataSource);
        song.insertSong("Beyonce","Jeff Parker","Forfolks",1);

        dataSource.close();
    }
}