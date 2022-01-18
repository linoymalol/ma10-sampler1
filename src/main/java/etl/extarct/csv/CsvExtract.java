package etl.extarct.csv;

import etl.extarct.Parser;
import etl.extarct.Reader;

import java.io.IOException;
import java.util.List;

public class CsvExtract implements Reader, Parser {

    @Override
    public List fileToList(Object object) throws IOException {
        return null;
    }

    @Override
    public Object read(String path) throws IOException {
        return null;
    }
}
