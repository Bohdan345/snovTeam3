package Utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class RandomData {


    public static int getRandomInt(int min, int max) {

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


    public static String getRandomName() {
        return "Test" + getRandomInt(1, 10000);
    }

    public static String getRandomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();

    }


    public static String getRandomEmailWithLocalPart(String localpart) {
        Faker faker = new Faker();
        return faker.internet().emailAddress(localpart);

    }
}
