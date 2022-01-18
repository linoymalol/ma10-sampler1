package etl.load.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import etl.load.Load;
import etl.load.ShareToFiles;
import etl.transform.Transform;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class JsonLoad implements Load{

    final int NUMBER_OF_RECORDS = 50000;

    public void load(String path, List listOfObjects) throws IOException {
        ShareToFiles shareToFiles = new ShareToFiles();
        int numberOfFiles = shareToFiles.numberOfFiles(listOfObjects, NUMBER_OF_RECORDS);
        int counter = 0;
        int indexInList = 0;
        while (counter != numberOfFiles) {
            ObjectMapper mapper = new ObjectMapper();
            if(NUMBER_OF_RECORDS * (counter + 1) > listOfObjects.size()){
                mapper.writeValue(new File(path), listOfObjects.subList(indexInList, listOfObjects.size()));
            }
            else {
                mapper.writeValue(new File(path), listOfObjects.subList(indexInList, NUMBER_OF_RECORDS * (counter + 1)));
            }
            indexInList = NUMBER_OF_RECORDS * (counter + 1);
            counter++;
            path = shareToFiles.newPath(path, counter);
        }
    }
}
