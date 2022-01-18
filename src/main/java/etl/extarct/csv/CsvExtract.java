package etl.extarct.csv;

import etl.EtlManager;
import etl.extarct.Extract;
import etl.extarct.Parser;
import etl.extarct.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvExtract {
    Extract csv = new Extract() {
        CsvReader csvReader = new CsvReader();
        CsvParser csvParser = new CsvParser();

        @Override
        public List extract(String path) throws IOException {
            return csvParser.fileToList(csvReader.read(path));
        }
    };
}

