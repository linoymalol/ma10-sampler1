package etl;

import com.google.common.io.Files;
import etl.extarct.Extract;
import etl.extarct.csv.CsvExtract;
import etl.load.Load;
import etl.transform.Transform;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class EtlManager  {
    private HashMap<String, Extract> extractHashMap;
    private HashMap<String, Transform> transformHashMap;
    private HashMap<String, Load> loadHashMap;


    public EtlManager(HashMap<String, Extract> extractHashMap, HashMap<String, Transform> transformHashMap,
                      HashMap<String, Load> loadHashMap){
        this.extractHashMap = extractHashMap;
        this.transformHashMap = transformHashMap;
        this.loadHashMap = loadHashMap;
    }

    public List extractTheFile(String fromFile) throws IOException {
        return extractHashMap.get(getExtensionByGuava(fromFile)).extract(fromFile);
    }

    public void loadToFile(String toFile, List listOfObjects) throws IOException {
        loadHashMap.get(getExtensionByGuava(toFile)).load(toFile, listOfObjects);
    }

    public void  process(String fromFile, String toFile) throws IOException {
        List listOfObjects = extractHashMap.get(getExtensionByGuava(fromFile)).extract(fromFile);
        loadHashMap.get(getExtensionByGuava(toFile)).load(toFile, listOfObjects);
    }

    public String getExtensionByGuava(String filename) {
    return Files.getFileExtension(filename);
  }
}



