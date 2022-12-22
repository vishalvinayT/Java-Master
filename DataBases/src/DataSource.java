import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static final String CONNECTION="jdbc:sqlite:";
    private static final String  PATH="D:\\SQL\\music\\";

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
