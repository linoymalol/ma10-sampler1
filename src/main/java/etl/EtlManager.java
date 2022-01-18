package etl;

import com.google.common.io.Files;
import etl.extarct.Extract;
import etl.extarct.csv.CsvExtract;
import etl.load.Load;
import etl.transform.Transform;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

public class EtlManager {
    HashMap<String, Extract> extract = new HashMap<>();
    HashMap<String, Transform> transform = new HashMap<>();
    HashMap<String, Load> load = new HashMap<>();
    HashMap[] arrOfProcess = {extract, transform, load};

    public void process(String fromFile, String ToFile){
        extract.get(getExtensionByGuava(fromFile), )
    }



    public String getExtensionByGuava(String filename) {
    return Files.getFileExtension(filename);
  }
}



