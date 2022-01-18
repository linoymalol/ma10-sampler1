package main;

import etl.EtlManager;
import etl.extarct.Extract;
import etl.extarct.csv.CsvExtract;
import etl.extarct.csv.CsvParser;
import etl.extarct.csv.CsvReader;
import etl.load.Load;
import etl.load.json.JsonLoad;
import etl.load.xml.XmlLoad;
import etl.transform.LabTestsTransform;
import etl.transform.Transform;
import health_care_provider.errors.InvalidIdException;
import labTests.LabTests;
import labTests.ListOfLabTests;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InvalidIdException {
        HashMap<String, Extract> extractHashMap = new HashMap<>();
        HashMap<String, Transform> transformHashMap = new HashMap<>();
        HashMap<String, Load> loadHashMap = new HashMap<>();
        CsvExtract csvExtract= new CsvExtract();
        extractHashMap.put("csv", csvExtract);
        JsonLoad jsonLoad = new JsonLoad();
        loadHashMap.put("json",jsonLoad);
        XmlLoad xmlLoad = new XmlLoad();
        loadHashMap.put("xml", xmlLoad);
        EtlManager etlManager = new EtlManager(extractHashMap, transformHashMap, loadHashMap);
        etlManager.process("src\\main\\resources\\MadaReports.csv", "C:\\mada_reports\\mada_reports_a.json");
       // etlManager.process("src\\main\\resources\\LabTests.csv", "C:\\LabTests\\LabTests.xml");


        CsvReader csvReader = new CsvReader();
        CsvParser csvParser = new CsvParser();
        List<CSVRecord> extractCsv = csvParser.fileToList(csvReader.read("src/main/resources/LabTests.csv"));
        ListOfLabTests newListOfMadaReports= new ListOfLabTests();
        List<LabTests> newList = newListOfMadaReports.labTestsList(extractCsv);
        LabTestsTransform labTestsTransform = new LabTestsTransform();
        List newList2 = labTestsTransform.transform(newList);
        xmlLoad.load("C:\\LabTests\\LabTests.xml",newList2);
    }

}