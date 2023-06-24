package org.example.setup;

import org.example.constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class SetupScripts {

    private WebDriver driver;

    // Поле ввода в одну сторону
    @FindBy(xpath = "/html/body/div[4]/form/div[1]/label[2]/input")
    private WebElement oneWay;
    // Поле ввода туда-обратно
    @FindBy(xpath = "/html/body/div[4]/form/div[1]/label[1]/input")
    private WebElement returnWay;
    // Поле ввода города вылета
    @FindBy(xpath = "/html/body/div[4]/form/div[2]/label[1]/input")
    private WebElement departureCity;
    // Поле ввода города прилета
    @FindBy(xpath = "/html/body/div[4]/form/div[2]/label[2]/input")
    private WebElement arrivalCity;
    // Поле ввода куда-угодно
    @FindBy(xpath = "//*[@id=\"anywhere\"]")
    private WebElement anyWhere;
    // Поле выбора дат в промежутке
    @FindBy(xpath = "//*[@id=\"flexiSel\"]")
    private WebElement flexDate;
    // Поле выбора фиксированной даты
    @FindBy(xpath = "//*[@id=\"nonflexiSel\"]")
    private WebElement nonFlexDate;
    // Поле выбора начальной даты, раскрытие месяца начального
    @FindBy(xpath = "//*[@id=\"nonflexiCal\"]/div[1]/div[1]/div")
    private WebElement startMonthDrop;
    // Поле выбора конечной даты, раскрытие месяца конечного
    @FindBy(xpath = "//*[@id=\"nonflexiCal\"]/div[1]/div[2]/div")
    private WebElement endMonthDrop;
    // Поле выбора начальной даты (месяца)
    @FindBy(xpath = "//*[@id=\"nonflexiCal\"]/div[1]/div[1]/div/select")
    private WebElement startDateOneWay;
    // Поле выбора конечной даты (месяца)
    @FindBy(xpath = "//*[@id=\"nonflexiCal\"]/div[1]/div[2]/div/select")
    private WebElement endDateOneWay;
    // Поле выбора минимального количества дней остановки
    @FindBy(xpath = "//*[@id=\"minDaysStay\"]")
    private WebElement minDaysStay;
    // Поле выбора максимального количества дней остановки
    @FindBy(xpath = "//*[@id=\"maxDaysStay\"]")
    private WebElement maxDaysStay;
    // Поле выбора расширения поиска на +- 5 дней
    @FindBy(xpath = "//*[@id=\"nonflexiparams\"]/input")
    private WebElement extendDays;
    // Поле выбора количества человек, раскрытие
    @FindBy(xpath = "//*[@id=\"people\"]/select[1]")
    private WebElement countOfAdults;
    // Кнопка искать
    @FindBy(xpath = "/html/body/div[4]/form/div[5]/input")
    private WebElement search;



    public WebDriver getDriver() {
        return driver;
    }


    public SetupScripts() throws IOException {
       openPage();
    }



    public void openPage() {
        System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        PageFactory.initElements(driver, this);
        driver.get(Constants.MAIN_PAGE_URL);
    }
    public void clickReturnWay(){
            returnWay.click();
    }
    public void clickOneWay(){
        oneWay.click();
    }
    public void setDepartureCity(){
        departureCity.click();
    }
    public void setArrivalCity(){
        arrivalCity.click();
    }
    public void setFlexDate(){
       flexDate.click();
    }
    public void setAnyWhere(){
        anyWhere.click();
    }
    public void setStartDateOneWay(){
        startDateOneWay.click();
    }
    public void setMinDaysStay(){
        minDaysStay.click();
    }
    public void setMaxDaysStay(){
        maxDaysStay.click();
    }
    public void setSearch(){

        search.click();
    }
    public String urlSite(){
        String url = driver.getCurrentUrl();
        System.out.println(url);
        return url;
    }


    public void setCountOfAdults(){
        countOfAdults.click();
    }
    public void enterStartDateDay(String dd) {
        stop:
        for (int i = 3; i < 9; i++) {
            for (int j = 1; j < 8; j++) {
                String xpath = "//*[@id=\"nonflexiCal\"]/div[1]/div[1]/table/tbody/tr[" + i + "]/td[" + j + "]";
                if (driver.findElement(By.xpath(xpath)).getText().equals(dd)) {
                    driver.findElement(By.xpath(xpath)).click();
                  break stop;
                }
            }
        }
    }

    public void enterEndDateDay(String dd) {
        stop:
        for (int i = 3; i < 9; i++) {
            for (int j = 1; j < 8; j++) {
                String xpath = "//*[@id=\"nonflexiCal\"]/div[1]/div[2]/table/tbody/tr[" + i + "]/td[" + j + "]";
                if (driver.findElement(By.xpath(xpath)).getText().equals(dd)) {
                    driver.findElement(By.xpath(xpath)).click();
                    break stop;
                }
            }
        }
    }



    public void enterDepartureCity(String depCity) {
        departureCity.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        departureCity.sendKeys(depCity);
        departureCity.sendKeys(Keys.DOWN);
        departureCity.sendKeys(Keys.ENTER);
    }
    public void enterArrivalCity(String arrCity) {
        arrivalCity.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        arrivalCity.sendKeys(arrCity);
        arrivalCity.sendKeys(Keys.DOWN);
        arrivalCity.sendKeys(Keys.ENTER);
    }
    public void enterMinDaysStay(String minDay) {
        minDaysStay.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        minDaysStay.sendKeys(minDay);
        minDaysStay.sendKeys(Keys.ENTER);
    }

    public void enterMaxDaysStay(String maxDay) {
        maxDaysStay.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        maxDaysStay.sendKeys(maxDay);
        maxDaysStay.sendKeys(Keys.ENTER);
    }
    public void enterCountOfAdults(String count) {
        Select start = new Select(countOfAdults);
        start.selectByValue(count);
    }
    public void setNonFlexDate(){
        nonFlexDate.click();
    }
    public void setStartMonthDrop(){
        startMonthDrop.click();
    }
    public void enterStartDateMonthAndYear(String yyyymm) {
        Select start = new Select(startDateOneWay);
        start.selectByValue(yyyymm);
    }

    public void enterEndDateMonthAndYear(String yyyymm) {
        Select start = new Select(endDateOneWay);
        start.selectByValue(yyyymm);
    }


}
