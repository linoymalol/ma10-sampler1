package etl.extarct;

import java.io.IOException;
import java.util.List;

public interface Parser <T>{
    List<T>fileToList(Object object) throws IOException;
}
