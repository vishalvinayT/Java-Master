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

    private static final String SONG_ARTISTS_QUERY="Select ar.name as artist_name, al.name as album_name, s.track  from songs s join albums al on s.album=al._id join artists ar on al.artist=ar._id ";
    private static final String  VIEW_SYNTAX="create view if not exists artists_list as ";
    private static final String ARTISTS_LIST=VIEW_SYNTAX+SONG_ARTISTS_QUERY;


    private static final String SONG_ARTISTS_QUERY_PH="Select ar.name as artist_name, al.name as album_name, s.track  from songs s join albums al on s.album=al._id join artists ar on al.artist=ar._id where s.title= ?";
    private static String DATABASE;
    protected Connection connection=null;
    private PreparedStatement queryForSongs=null;

    private static DataSource instance=new DataSource();
    public DataSource(String database){
        DATABASE=database;
    }
    private DataSource(){
        DATABASE="music.db";
    };

    public static DataSource getInstance(){
        return instance;
    }



    public void open(){
        if(DATABASE!=null){
            try{
                connection= DriverManager.getConnection(CONNECTION+PATH+DATABASE);
                queryForSongs=connection.prepareStatement(SONG_ARTISTS_QUERY_PH);
            }catch (SQLException e){
                System.out.println("Failed to connect "+ e.getMessage());
            }
        }
    }


    public void close(){
        if(connection!=null){
            try {
                queryForSongs.close();
                connection.close();
            }catch (SQLException e){
                System.out.println("Failed to close connection "+e.getMessage());
            }
        }
    }

    // retuns all the artists from artist table using String concatination
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

    // returns all the songs through searchong by artists using String Concatination
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

    // returns album , artist, track of a song through String concatination;
    public List<SongArtist> searchBySong(String name, int orderBy){
        String Query=SONG_ARTISTS_QUERY+" where s.title= \"" +name+"\"";
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

    // returna artists, albums for a song using place holders
    public List<SongArtist> searchBySong_ph(String name){
        List<SongArtist> artists=new ArrayList<>();
        if(connection!=null){
            ResultSet resultSet=null;

            try {
                queryForSongs.setString(1,name);
                resultSet=queryForSongs.executeQuery();
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


    // returns count of all songs
    public int getSongCount(){
        String Query="select count(*) from songs ";
        Statement statement=null;
        ResultSet result=  null;
        try{
            statement=connection.createStatement();
            result=statement.executeQuery(Query);
            while(result.next()){
                System.out.println("Count: "+ result.getInt(1));
                return result.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();

        }
        return 0;
    }


    // view artists of song
    public void createViewArrtists(){
        String Query=ARTISTS_LIST;
        Statement statement=null;
        try{
            statement=connection.createStatement();
            statement.execute(Query);
        }catch (SQLException e){
            System.out.println("Failed to Create view "+e.getMessage());
        }
    }

    // view the artist_list view
    public List<SongArtist> viewArtists(){
        String Query="select * from artists_list";
        List<SongArtist> artists= new ArrayList<>();
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




}
