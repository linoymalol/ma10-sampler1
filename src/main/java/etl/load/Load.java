package etl.load;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public interface Load <T> {
    public void objectToJson(String path, List listOfObjects) throws IOException;
}
