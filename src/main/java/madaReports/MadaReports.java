package madaReports;

import org.apache.commons.csv.CSVRecord;

public class MadaReports {
    private String mdaCode;
    private String idNum;
    private int idType;
    private String firstName;
    private String lastName;
    private String city;
    private String street;
    private int buildingNumber;
    private String barCode;
    private String getDate;
    private String takeDate;
    private String resultDate;

    public String getMdaCode() {
        return mdaCode;
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

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public String getBarCode() {
        return barCode;
    }

    public String getGetDate() {
        return getDate;
    }

    public String getTakeDate() {
        return takeDate;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setMdaCode(String mdaCode) {
        this.mdaCode = mdaCode;
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

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public void setGetDate(String getDate) {
        this.getDate = getDate;
    }

    public void setTakeDate(String takeDate) {
        this.takeDate = takeDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public MadaReports(CSVRecord rec) {
        this.mdaCode = rec.get(0);
        this.idNum = rec.get(1);
        this.idType = Integer.parseInt(rec.get(2));
        this.firstName = rec.get(3);
        this.lastName = rec.get(4);
        this.city = rec.get(5);
        this.street = rec.get(6);
        this.buildingNumber = Integer.parseInt(rec.get(7));
        this.barCode = rec.get(8);
        this.getDate = rec.get(9);
        this.takeDate = rec.get(10);
        this.resultDate = rec.get(11);
    }

    @Override
    public String toString() {
        return "MadaReports{" +
                "mdaCode='" + mdaCode + '\'' +
                ", idNum='" + idNum + '\'' +
                ", idType=" + idType +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", barCode='" + barCode + '\'' +
                ", getDate='" + getDate + '\'' +
                ", takeDate='" + takeDate + '\'' +
                ", resultDate='" + resultDate + '\'' +
                '}';
    }
}
