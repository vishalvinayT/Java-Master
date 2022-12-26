import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSong {

    private static final String ADD_ARTIST="insert into artists(name) values(?)";
    private static final String ADD_ALBUM="insert into albums(name,artist) values(?,?)";
    private static final String ADD_SONG="insert into songs(track,title,album) values(?,?,?)";

    private static final String CHECK_ARTIST="select _id from artists where name= ? ";
    private static final String CHECK_ALBUM="select _id from albums where name= ? and artist=?";
    private static final String CHECK_SONG="select _id from songs where title= ?  and album= ?";

    private PreparedStatement queryAddArtists;
    private PreparedStatement queryAddAlbums;
    private PreparedStatement queryAddSongs;

    private PreparedStatement queryCheckArtist;
    private PreparedStatement queryCheckAlbum;
    private PreparedStatement queryCheckSong;

    private DataSource instance;
    public InsertSong(DataSource source)  {
        if(source.connection!=null){
            instance=source;
        }
    }
    public void openResources(){
        try{
            queryAddArtists=instance.connection.prepareStatement(ADD_ARTIST, Statement.RETURN_GENERATED_KEYS);
            queryAddAlbums=instance.connection.prepareStatement(ADD_ALBUM,Statement.RETURN_GENERATED_KEYS);
            queryAddSongs=instance.connection.prepareStatement(ADD_SONG);
            queryCheckArtist=instance.connection.prepareStatement(CHECK_ARTIST);
            queryCheckAlbum=instance.connection.prepareStatement(CHECK_ALBUM);
            queryCheckSong=instance.connection.prepareStatement(CHECK_SONG);
        }catch (SQLException e){
            System.out.println("Failed to connect prepared statement "+ e.getMessage());
        }
    }

    public void closeResources(){
        try{
            queryAddArtists.close();
            queryAddAlbums.close();
            queryAddSongs.close();
            queryCheckArtist.close();
            queryCheckAlbum.close();
            queryCheckSong.close();
        }catch (SQLException e){
            System.out.println("Failed to connect prepared statement "+ e.getMessage());
        }
    }
    private int insertArtist(String name){
        try {
            queryCheckArtist.setString(1,name);
            ResultSet check=queryCheckArtist.executeQuery();
            int id=check.getInt(1);
            if(id>0){
                return id;
            }
            else{
                queryAddArtists.setString(1,name);
                int addedArtists=queryAddArtists.executeUpdate();
                if(addedArtists==1){
                    ResultSet res=queryAddArtists.getGeneratedKeys();
                    return res.getInt(1);
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return 0;
    }


    private int insertAlbum(String name, int artist){
        try {
            queryCheckAlbum.setString(1,name);
            queryCheckAlbum.setInt(2,artist);
            ResultSet check=queryCheckAlbum.executeQuery();
            int id=check.getInt(1);
            if(id>0){
                return id;
            }
            queryAddAlbums.setString(1,name);
            queryAddAlbums.setInt(2,artist);
            int addedArtists=queryAddAlbums.executeUpdate();
            if(addedArtists==1){
                ResultSet res=queryAddAlbums.getGeneratedKeys();
                return res.getInt(1);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }


    public void insertSong(String artistName, String albumName, String songName, int track){
        boolean added=false;
        openResources();
        try {
            instance.connection.setAutoCommit(false);
            int artistID=insertArtist(artistName);
            int albumID=insertAlbum(albumName,artistID);
            queryCheckSong.setString(1,songName);
            queryCheckSong.setInt(2,albumID);
            ResultSet check=queryCheckSong.executeQuery();
            int id=check.getInt(1);
            if(id>0){
                System.out.println("Oops! song already exists");
                added=true;
            }
            else{
                queryAddSongs.setInt(1, track);
                queryAddSongs.setString(2,songName);
                queryAddSongs.setInt(3,albumID);

                int addedSong=queryAddSongs.executeUpdate();
                if(addedSong==1){
                    System.out.println("Song added Sucessfully");
                    instance.connection.commit();
                    added=true;
                }else{
                    System.out.println("Failed to add song");
                    instance.connection.rollback();
                }
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if(added){
                    instance.connection.setAutoCommit(true);
                }
                else{
                    throw  new SQLException();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
            closeResources();
        }
    }
}
