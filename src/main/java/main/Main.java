package main;

import MadaReports.ListOfMadaReports;
import MadaReports.MadaReports;
import etl.extarct.csv.CsvParser;
import etl.extarct.csv.CsvReader;
import etl.load.json.JsonLoad;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
       // Extract csv = new CsvReader();
        CsvReader csvReader = new CsvReader();
        CsvParser csvParser = new CsvParser();
        List<CSVRecord> extractCsv = csvParser.fileToList(csvReader.read("src/main/resources/MadaReports.csv"));
        ListOfMadaReports newListOfMadaReports= new ListOfMadaReports();
        List<MadaReports> newList = newListOfMadaReports.madaReportsList(extractCsv);
        //  for (MadaReports m: newList) {
        //    System.out.println(m.toString());
      //  }
        //int countOfFiles = 51000/50000 + 1;
        //System.out.println(countOfFiles);
        JsonLoad jsonLoad = new JsonLoad();
        //Object madaReports = new Object(); // jsonLoad.createFile( "C:\\mada_reports\\mada_reports_a.json");
        jsonLoad.objectToJson("C:\\mada_reports\\mada_reports_a.json", newList);
       // System.out.println(jsonLoad.newPath("C:\\mada_reports\\mada_reports_a.json", 2));
    }

}