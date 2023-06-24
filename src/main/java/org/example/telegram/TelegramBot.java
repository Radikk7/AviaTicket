package org.example.telegram;

import org.example.setup.SetupScripts;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import parsing.DataRequest;
import parsing.Flight;
import parsing.Parsing;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TelegramBot extends TelegramLongPollingBot {
    int count = 0;

    private String typeFlight = "";
    private String answer = "";
    private String clashed = "";
    public static List<String> comandList = new ArrayList<>();


    @Override
    public String getBotUsername() {
        return "AviaTickett_bot";
    }

    @Override
    public String getBotToken() {
        return "6153340699:AAG0RzLKeUu75gR2mwssfNLEnCFJj5TGigM";
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        Long id = update.getMessage().getChatId();
        sendMessage.setChatId(String.valueOf(id));
        String message_text = update.getMessage().getText();
        StringBuilder stringBuilder = new StringBuilder();


        if (message_text.equals("/start")) {
            stringBuilder.append("/return");
            stringBuilder.append("\n");
            stringBuilder.append("/oneway");
            sendMessage.setText(String.valueOf(stringBuilder));
            answer = stringBuilder.toString();
            comandList.add(message_text);
            System.out.println(comandList);
        } else if (message_text.equals("/return")) {
            typeFlight = "return";
            sendMessage.setText("Enter the cities where we are flying in return");
            answer = "Enter the cities where we are flying in return";
            System.out.println(message_text);
            comandList.add(message_text);
            System.out.println(comandList);
        } else if (answer.equals("Enter the cities where we are flying in return")) {
            sendMessage.setText("enter dates");
            answer = "enter dates";
            comandList.add(message_text);
            System.out.println(comandList);
        } else if (answer.equals("enter dates")) {
            answer = "How many people are flying";
            sendMessage.setText("How many people are flying");
            comandList.add(message_text);
            System.out.println(comandList);
        } else if (answer.equals("How many people are flying")) {
            answer = "Waiting";
            sendMessage.setText("Waiting");
            comandList.add(message_text);
            System.out.println(comandList);
            try {
                startProgram(comandList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void startProgram(List<String> stringList) throws IOException {
        DataRequest dataRequest = new DataRequest();
        String[] array = new String[stringList.size()];
        String[] array2 = new String[stringList.size()];
        String[] array3 = new String[stringList.size()];
        array = stringList.get(2).split("\\s+");
        array2 = stringList.get(3).split("\\s+");
        array3 = stringList.get(4).split("\\s+");//по идее здесь берём количество пассажиров
        dataRequest.setDepartCity(array[0]);
        dataRequest.setArrivalCity(array[2]);
        dataRequest.setStartDate(array2[0]);
        dataRequest.setLastDate(array2[2]);
        dataRequest.setNumberOfPassengers(array3[0]);
        startQa(dataRequest);


    }

    public void startQa(DataRequest dataRequest) throws IOException {
        SetupScripts setupScripts = new SetupScripts();

        setupScripts.clickReturnWay();
        setupScripts.enterDepartureCity(dataRequest.getDepartCity());
        setupScripts.enterArrivalCity(dataRequest.getArrivalCity());
        setupScripts.setNonFlexDate();
        setupScripts.enterStartDateMonthAndYear(convertYearMonths(dataRequest.getStartDate()));
        setupScripts.enterStartDateDay(convertDay(dataRequest.getStartDate()));
        setupScripts.enterEndDateMonthAndYear(convertYearMonths(dataRequest.getLastDate()));
        setupScripts.enterEndDateDay(convertDay(dataRequest.getLastDate()));
        setupScripts.enterCountOfAdults(dataRequest.getNumberOfPassengers());
        setupScripts.setSearch();
        String link = setupScripts.urlSite();
        Parsing.flightListParsing(link);
        List<Flight> flightList = Parsing.flightListParsing(link);
        String flight = convector(flightList);
        System.out.println(flight);
    }

    public static String convector(List<Flight> stringList) {
        String stringFlight = "";
        for (int i = 0; i < stringList.size() - 1; i++) {
            stringFlight += stringList.get(i) + "\n" + "\n";
        }
        return stringFlight;
    }

    public static String convertDay(String str) {
        char[] chars = str.toCharArray();
        String day = "";
        day = String.valueOf(chars[0] + "" + chars[1]);
        return day;
    }

    public static String convertYearMonths(String str) {
        char[] chars = str.toCharArray();
        // допилить этот конвектор и попробовать запустить
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(str, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyyMM");
        String outputDate = date.format(outputFormatter);
        System.out.println(outputDate);
        return outputDate;

    }
}

