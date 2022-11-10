import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.util.Locale;

public class DataHelper {

    private DataHelper(){
    }
    private static  Faker faker = new Faker(new Locale("en"));

    @Value

    public static class cardInfo{
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cvc;
    }

    public static String cardNumber(){ //номер карты
        return "4444 4444 4444 4441";
    }

    public static String currentMonth(){ //текущий месяц
        LocalDate currentMonth = LocalDate.now();
        int month = currentMonth.getMonthValue();
        return String.format("%02d", month);
    }
    public static String zeroMonth(){ // нулевой месяц
        LocalDate currentMonth = LocalDate.now();
        int month = currentMonth.getMonthValue()-currentMonth.getMonthValue();
        return String.format("%02d", month);
    }
    public static String owner() { //владелец
        return faker.name().fullName();
    }
    public static String currentYear() { //текущий год
        LocalDate currentYear = LocalDate.now();
        int year = currentYear.getYear() - 2022;
        return Integer.toString(year);
    }
    public static String lastYear() { //прошедший год
        LocalDate currentYear = LocalDate.now();
        int year = currentYear.getYear() - 2021;
        return Integer.toString(year);
    }
    public static String CVC(){
        return faker.number().digits(123);
    }
    public static cardInfo validFields(){ //валидные поля
        return new cardInfo(cardNumber(),currentMonth(),currentYear(),owner(),CVC());
    }
    public static cardInfo unregisteredСard(){ //не зарегистрированная карта
        return new cardInfo("4444", currentMonth(),currentYear(),owner(),CVC());
    }

}
