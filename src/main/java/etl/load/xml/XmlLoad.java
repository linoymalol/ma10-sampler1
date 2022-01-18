package etl.load.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import etl.load.Load;
import etl.load.ShareToFiles;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XmlLoad implements Load {

    final int NUMBER_OF_RECORDS = 50000;

    @Override
    public void load(String path, List listOfObjects) throws IOException {
        ShareToFiles shareToFiles = new ShareToFiles();
        int numberOfFiles = shareToFiles.numberOfFiles(listOfObjects, NUMBER_OF_RECORDS);
        int counter = 0;
        int indexInList = 0;
        while (counter != numberOfFiles) {
            XmlMapper xmlMapper = new XmlMapper();
            if (NUMBER_OF_RECORDS * (counter + 1) > listOfObjects.size()) {
                xmlMapper.writeValue(new File(path), listOfObjects.subList(indexInList, listOfObjects.size()));
            } else {
                xmlMapper.writeValue(new File(path), listOfObjects.subList(indexInList, NUMBER_OF_RECORDS * (counter + 1)));
            }
            indexInList = NUMBER_OF_RECORDS * (counter + 1);
            counter++;
            path = shareToFiles.newPath(path, counter);
        }
    }
}
