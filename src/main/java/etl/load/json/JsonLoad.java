package etl.load.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import etl.load.Load;

import java.io.*;
import java.util.List;


public class JsonLoad implements Load {

    final int NUMBER_OF_RECORDS = 50000;

    public void objectToJson(String path, List listOfObjects) throws IOException {
        int numberOfFiles = numberOfFiles(listOfObjects);
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
            path = newPath(path, counter);
        }
    }

    public String newPath(String path, int numberOfFile) {
        int index = path.indexOf('.');
        String startString = path.substring(0, index - 1);
        String endString = path.substring(index, path.length());
        return startString + "" + numberOfFile + endString;
    }

    public int numberOfFiles(List listOfObjects) {
        if (listOfObjects.size() % NUMBER_OF_RECORDS == 0) {
            return listOfObjects.size() / NUMBER_OF_RECORDS;
        }
        return listOfObjects.size() / NUMBER_OF_RECORDS + 1;
    }
}
