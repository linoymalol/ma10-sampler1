package etl.extarct.csv;

import etl.extarct.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.FileReader;
import java.io.IOException;

public class CsvReader implements Reader {
    public Object read(String path) throws IOException {
        return new CSVParser(new FileReader(path), CSVFormat.DEFAULT);
    }
}
