package za.ac.cput.factory.user;

import za.ac.cput.domain.user.Driver;

import za.ac.cput.util.Helper;

/*Mponeng Ratego
 216178991
 */


public class DriverFactory {

    public static Driver createDriver(String firstName, String lastName, String driverCode) {
        String idNumber = Helper.generateID();

        if (isInvalidParameters(idNumber, firstName, lastName, driverCode))
            throw new IllegalArgumentException("Error alert Invalid values");

        return new Driver.Builder()
                .setIdNumber(idNumber)
                .setDriverCode(driverCode)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();

    }


    private static boolean isInvalidParameters(String idNumber, String driverCode, String firstName, String lastName) {
        return (
                Helper.isNullOrEmpty(idNumber) ||
                        Helper.isNullOrEmpty(driverCode) || Helper.isNullOrEmpty(firstName) ||
                        Helper.isNullOrEmpty(lastName)
        );
    }

    public static void buildDriver(Object o) {
    }
}

