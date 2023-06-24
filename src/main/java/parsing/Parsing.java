package parsing;

import org.example.setup.SetupScripts;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parsing {
    public static List<Flight> flightListParsing (String link) throws IOException {
        Document doc = Jsoup.connect(link).maxBodySize(0).get();
        List<Flight> flightList = new ArrayList<>();
        Elements lines = doc.getElementsByClass("result");
        for (Element i : lines) {
            Flight flight = new Flight();
            String[] array7 = i.text().split(" ");
            String[] arrayPrice = i.text().split("€");
            String[] arrayPriceEuro = arrayPrice[1].split(" ");
              flight.setPrice("€" + arrayPriceEuro[0]);
              flight.setArrivalTime(array7[6]);
              flight.setArrivalCity(array7[7]);
              flight.setArrivalAirportCode(array7[8]);
              flight.setCity(array7[4]);//ok
              flight.setAirportCode(array7[5]);//ok
              flight.setFlightTime(array7[2] + " " + array7[3]);// ok
              flight.setDayOfWeek(array7[1]);//ok
            flightList.add(flight);
        }
       return flightList;
    }


}
