import java.sql.Statement;
import java.util.List;

public class Artists {
    private Statement statement;
    private List<Artists> artists;
    private int _id;
    private String name;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
