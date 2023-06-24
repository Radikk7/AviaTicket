package parsing;

public class Flight {
    private String City;
    private String airportCode;
    private String flightTime;
    private String price;
    private String dayOfWeek;
    private String arrivalTime;
    private String arrivalCity;
    private String arrivalAirportCode;

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Flight(String city, String airportCode, String flightTime, String price, String dayOfWeek, String arrivalTime, String arrivalCity, String arrivalAirportCode) {
        City = city;
        this.airportCode = airportCode;
        this.flightTime = flightTime;
        this.price = price;
        this.dayOfWeek = dayOfWeek;
        this.arrivalTime = arrivalTime;
        this.arrivalCity = arrivalCity;
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public Flight() {
    }

    public String toString(){
        return getCity() + " " + getAirportCode() + " " + getFlightTime() + " " + getPrice() + " " + getDayOfWeek() +
                " " + getArrivalTime() + " " + getArrivalCity() + " " + getArrivalAirportCode() ;
    }
}
