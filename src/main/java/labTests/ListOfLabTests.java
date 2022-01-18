package labTests;

import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.List;

public class ListOfLabTests {
    public List<LabTests> labTestsList(List<CSVRecord> listOfRecords) {
        List<LabTests> labTestsList = new ArrayList<>();
        boolean firstRecord = true;
        for(CSVRecord record:listOfRecords){
            if (!firstRecord){
                labTestsList.add(new LabTests(record));}
            firstRecord = false;
        }
        return labTestsList;
    }
}
