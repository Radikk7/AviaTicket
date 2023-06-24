package parsing;

public class DataRequest {
   private String departCity = "";
   private String arrivalCity = "";
   private String startDate = "";
   private String lastDate = "";
   private String numberOfPassengers = "";

    public String getDepartCity() {
        return departCity;
    }

    public void setDepartCity(String departCity) {
        this.departCity = departCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(String numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public DataRequest() {
    }

    public DataRequest(String departCity, String arrivalCity, String startDate, String lastDate, String numberOfPassengers) {
        this.departCity = departCity;
        this.arrivalCity = arrivalCity;
        this.startDate = startDate;
        this.lastDate = lastDate;
        this.numberOfPassengers = numberOfPassengers;
    }
    public String toString(){
        return getDepartCity() + " " + getArrivalCity() + " " + getStartDate() + " " + getLastDate() + " " + getNumberOfPassengers();
    }
}
