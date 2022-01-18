package etl.extarct;

import java.io.IOException;
import java.util.List;

public interface Extract {
    List extract(String path) throws IOException;
}
