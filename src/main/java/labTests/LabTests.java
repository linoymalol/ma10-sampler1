package labTests;

import org.apache.commons.csv.CSVRecord;

import java.util.HashMap;

public class LabTests {
    private String idNum;
    private int idType;
    private String firstName;
    private String lastName;
    private String resultDate;
    private String birthDate;
    private String labCode;
    private String stickerNumber;
    private int resultTestCorona;
    private String variant;
    private String testType;
    private HashMap<String, Object> properties = new HashMap<>();

    public LabTests(CSVRecord rec){
        this.idNum = rec.get(0);
        this.idType = Integer.parseInt(rec.get(1));
        this.firstName = rec.get(2);
        this.lastName = rec.get(3);
        this.resultDate = rec.get(4);
        this.birthDate = rec.get(5);
        this.labCode = rec.get(6);
        this.stickerNumber = rec.get(7);
        this.resultTestCorona = Integer.parseInt(rec.get(8));
        this.variant = rec.get(9);
        this.testType = rec.get(10);
    }

    public LabTests(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    public String getIdNum() {
        return idNum;
    }

    public int getIdType() {
        return idType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getResultDate() {
        return resultDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getLabCode() {
        return labCode;
    }

    public String getStickerNumber() {
        return stickerNumber;
    }

    public int getResultTestCorona() {
        return resultTestCorona;
    }

    public String getVariant() {
        return variant;
    }

    public String getTestType() {
        return testType;
    }

    public Object getProperty(String key) {
        return this.properties.getOrDefault(key, null);
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setLabCode(String labCode) {
        this.labCode = labCode;
    }

    public void setStickerNumber(String stickerNumber) {
        this.stickerNumber = stickerNumber;
    }

    public void setResultTestCorona(int resultTestCorona) {
        this.resultTestCorona = resultTestCorona;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public Object setProperty(String key, Object value) {
        return this.properties.put(key, value);
    }
}
