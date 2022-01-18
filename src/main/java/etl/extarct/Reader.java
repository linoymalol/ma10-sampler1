package etl.extarct;

import java.io.IOException;

public interface Reader <T> {
    Object read(String path) throws IOException;
}
