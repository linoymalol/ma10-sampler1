package etl.extarct;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Reader <T> {
    Object read(String path) throws IOException;
}
