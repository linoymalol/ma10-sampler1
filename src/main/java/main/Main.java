package main;

import etl.EtlManager;
import etl.extarct.Extract;
import etl.extarct.csv.CsvExtract;
import madaReports.ListOfMadaReports;
import madaReports.MadaReports;
import etl.extarct.csv.CsvParser;
import etl.extarct.csv.CsvReader;
import etl.load.json.JsonLoad;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        CsvReader csvReader = new CsvReader();
        CsvParser csvParser = new CsvParser();
        List<CSVRecord> extractCsv = csvParser.fileToList(csvReader.read("src/main/resources/MadaReports.csv"));
        ListOfMadaReports newListOfMadaReports= new ListOfMadaReports();
        List<MadaReports> newList = newListOfMadaReports.madaReportsList(extractCsv);
        JsonLoad jsonLoad = new JsonLoad();
        jsonLoad.load("C:\\mada_reports\\mada_reports_a.json", newList);
        //EtlManager man = new EtlManager();
       // man.extractTheFile("src/main/resources/MadaReports.csv");
        //System.out.println(man.getExtensionByGuava("C:\\mada_reports\\mada_reports_a.csv"));
    }

}