package org.mapstruct.ap.test.nestedbeans;


import java.util.Arrays;

public class TestData {

    public static User createUser() {
        return getOldUser();
    }
//
//    private static User getNewUser() {
//        return new User("John", new Car("Chrysler", 1955), new House("Black", 1834, new Roof(1)));
//    }

    private static User getOldUser() {
        return new User("John", new Car("Chrysler", 1955, Arrays.asList(
                new Wheel().front().left(),
                new Wheel().front().right(),
                new Wheel().rear().left(),
                new Wheel().rear().right())),
                new House("Black", 1834, new Roof(1)));
    }
}
