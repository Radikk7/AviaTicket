package org.example;

import org.example.setup.SetupScripts;
import org.example.telegram.TelegramBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import parsing.DataRequest;
import parsing.Flight;
import parsing.Parsing;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new TelegramBot());
        TelegramBot telegramBot = new TelegramBot();


        //  List<String> stringList = TelegramBot.comandList;
      //  String [] array = new String[stringList.size()];
      //  String departCity = "";
      //  String arrivalCity = "";
      //  for (String i: stringList) {
      //      array = i.split("\\s+");
      //      departCity = array[3];
      //      arrivalCity = array[5];
      //  }
      //  System.out.println("!!!!!!!! " + departCity + " " + arrivalCity);


    //   SetupScripts setupScripts = new SetupScripts();
    //   setupScripts.clickReturnWay();
    //   setupScripts.enterDepartureCity("Hamburg");
    //   setupScripts.enterArrivalCity("New York");
    //   setupScripts.setAnyWhere();
    //   setupScripts.setNonFlexDate();
    //   setupScripts.enterStartDateMonthAndYear("202306");
    //   setupScripts.enterStartDateDay("13");
    //   setupScripts.enterEndDateMonthAndYear("202307");
    //   setupScripts.enterEndDateDay("7");
    //   setupScripts.enterCountOfAdults("2");

    //   setupScripts.setSearch();
    //   String link = setupScripts.urlSite();
    //   Parsing.flightListParsing(link);

    //   List<Flight> flightList = Parsing.flightListParsing(link);
    //   String flight = convector(flightList);
    //   System.out.println(flight);

    }

    public static String convector(List<Flight> stringList) {
        String stringFlight = "";
        for (int i = 0; i < stringList.size() - 1; i++) {
            stringFlight += stringList.get(i) + "\n" + "\n";
        }
        return stringFlight;
    }
}
