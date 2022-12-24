
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String database="music.db";
        DataSource dataSource= new DataSource(database);
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

        List<SongArtist> artists=dataSource.searchBySong("Your Time Is Gonna Come",DataSource.ORDER_BY_ASC);
        for(SongArtist sa: artists){
            System.out.println("Artist name : "+ sa.getArtistName()+" Album name: "+ sa.getAlbumName()+" track: "+ sa.getTrack());
        }
        dataSource.close();
    }
}