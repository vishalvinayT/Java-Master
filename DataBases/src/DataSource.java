import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static final String CONNECTION="jdbc:sqlite:";
    private static final String  PATH="D:\\SQL\\music\\";

    public static final int ORDER_BY_ASC=0;
    public  static  final int ORDER_BY_DESC=1;

    private static String ARTISTS="artists";
    private static String ALBUMS="albums";
    private static String SONGS="songs";

    private static String DATABASE;

    private Connection connection=null;
    public DataSource(String database){
        DATABASE=database;
    }

    public List<Artists> getArrists(){
        String query="select _id,name from "+ARTISTS;
        Statement statement=null;
        List<Artists> artists=new ArrayList<>();
        if(connection!=null){
            try{
                statement=connection.createStatement();
                ResultSet result= statement.executeQuery(query);
                while(result.next()){
                    Artists artist= new Artists();
                    artist.set_id(result.getInt("_id"));
                    artist.setName(result.getString("name"));
                    artists.add(artist);
                }
                return artists;
            }catch (SQLException e){
                System.out.println("Failed to execute Query "+e.getMessage());
            }
        }
        return artists;

    }

    public List<SongArtist> searchBySong(String name, int orderBy){
        String Query="Select ar.name as artist_name, al.name as album_name, s.track  from songs s join albums al on s.album=al._id join artists ar on al.artist=ar._id where s.title= \""+name+"\"";
        List<SongArtist> artists=new ArrayList<>();
        if(orderBy==ORDER_BY_DESC){
            Query+=" order by s.title Desc";
        }
        else{
            Query+=" order by s.title Asc";
        }
        if(connection!=null){
            Statement statement=null;
            ResultSet resultSet=null;

            try {
                statement=connection.createStatement();
                resultSet=statement.executeQuery(Query);
                while(resultSet.next()){
                    SongArtist artist=new SongArtist();
                    artist.setArtistName(resultSet.getString(1));
                    artist.setAlbumName(resultSet.getString(2));
                    artist.setTrack(resultSet.getInt(3));
                    artists.add(artist);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return artists;
    }

    public List<String> searchByArtists(String name, int OrderBy){
        String Query="Select s.title from songs s join albums al on s.album=al._id join artists ar on al.artist=ar._id where ar.name= \""+name+"\"";
        List<String> songs=new ArrayList<>();
        if(OrderBy==ORDER_BY_DESC){
            Query+=" order by s.title Desc";
        }
        else{
            Query+=" order by s.title Asc";
        }
        if(connection!=null){
            Statement statement=null;
            ResultSet resultSet=null;

            try {
                statement=connection.createStatement();
                resultSet=statement.executeQuery(Query);
                while(resultSet.next()){
                    songs.add(resultSet.getString(1));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return songs;
    }


    public void open(){
        if(DATABASE!=null){
            try{
                connection= DriverManager.getConnection(CONNECTION+PATH+DATABASE);
            }catch (SQLException e){
                System.out.println("Failed to connect "+ e.getMessage());
            }
        }
    }


    public void close(){
        if(connection!=null){
            try {
                connection.close();
            }catch (SQLException e){
                System.out.println("Failed to close connection "+e.getMessage());
            }
        }
    }

}
