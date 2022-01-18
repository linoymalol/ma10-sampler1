package madaReports;

import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.List;

public class ListOfMadaReports {
    public List<MadaReports> madaReportsList(List<CSVRecord> listOfRecords) {
        List<MadaReports> madaReportsList = new ArrayList<>();
        boolean firstRecord = true;
        for(CSVRecord record:listOfRecords){
            if (!firstRecord){
            madaReportsList.add(new MadaReports(record));}
            firstRecord = false;
        }
        return madaReportsList;
    }
}
