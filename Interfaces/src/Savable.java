import java.util.ArrayList;
import java.util.List;

public interface Savable {
    List<String> write();
    void read(List<String> values);


}
