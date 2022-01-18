package etl.load;

import java.util.List;

public class ShareToFiles {
    public String newPath(String path, int numberOfFile) {
        int index = path.indexOf('.');
        String startString = path.substring(0, index - 1);
        String endString = path.substring(index, path.length());
        return startString + "" + numberOfFile + endString;
    }

    public int numberOfFiles(List listOfObjects, int numberOfRecords) {
        if (listOfObjects.size() % numberOfRecords == 0) {
            return listOfObjects.size() / numberOfRecords;
        }
        return listOfObjects.size() / numberOfRecords + 1;
    }
}
