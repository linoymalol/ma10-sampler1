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
    public HashMap<String, Extract> extractHashMap = new HashMap<>();
    public HashMap<String, Transform> transformHashMap = new HashMap<>();
    public HashMap<String, Load> loadHashMap = new HashMap<>();

    public void addToExtractHashMap(HashMap<String,Extract> extract){
       // extract.put("csv", CsvExtract);
    }

    public List extractTheFile(String fromFile) throws IOException {
        return extractHashMap.get(getExtensionByGuava(fromFile)).extract(fromFile);
    }

    public void loadToFile(String toFile, List listOfObjects) throws IOException {
        loadHashMap.get(getExtensionByGuava(toFile)).load(toFile, listOfObjects);
    }

    public String getExtensionByGuava(String filename) {
    return Files.getFileExtension(filename);
  }
}



