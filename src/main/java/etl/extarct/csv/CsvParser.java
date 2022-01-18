package etl.extarct.csv;

import etl.extarct.Parser;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.List;

public class CsvParser implements Parser {
    @Override
    public List fileToList(Object object) throws IOException {
        CSVParser parser = (CSVParser) object;
        List<CSVRecord> records = parser.getRecords();
        return records;

    }
}
