package etl.transform;

import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import labTests.LabTests;

import java.util.HashMap;
import java.util.List;

public class LabTestsTransform {
    public List transform(List<LabTests> listOfObjects) throws InvalidIdException {
        HealthCareInfoProvider healthCareInfoProvider = new HealthCareInfoProvider();
        HashMap<String, Object> properties = new HashMap<>();
        for (int i = 0; i < listOfObjects.size(); i++) {
            if (listOfObjects.get(i).getIdType() > 99999999 && listOfObjects.get(i).getIdType() < 1000000000) {
                listOfObjects.get(i).setProperty("JOIN_DATE", healthCareInfoProvider.fetchInfo
                        (Integer.parseInt(listOfObjects.get(i).getIdNum()), listOfObjects.get(i).getIdType()).getJoinDate());
                listOfObjects.get(i).setProperty("HEALTH_CARE_ID", healthCareInfoProvider.fetchInfo
                        (Integer.parseInt(listOfObjects.get(i).getIdNum()), listOfObjects.get(i).getIdType()).getHealthCareId());
                listOfObjects.get(i).setProperty("HEALTH_CARE_NAME", healthCareInfoProvider.fetchInfo
                        (Integer.parseInt(listOfObjects.get(i).getIdNum()), listOfObjects.get(i).getIdType()).getHealthCareName());
            }
        }
        return listOfObjects;
    }
}
