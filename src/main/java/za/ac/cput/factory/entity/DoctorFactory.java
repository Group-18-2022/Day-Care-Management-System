package za.ac.cput.factory.entity;

import za.ac.cput.domain.entity.Doctor;
import za.ac.cput.util.Helper;

/* Author : Karl Haupt
 * Student Number: 220236585
 */

// TODO: Valid phoneNumber + test case

public class DoctorFactory {

    public static Doctor buildDoctor(String practiceName, String firstName, String lastName, String phoneNumber) {
        String doctorID = Helper.generateID();

        if(isInvalidParameters(doctorID, practiceName, firstName, lastName, phoneNumber))
            throw new IllegalArgumentException("Error: Invalid value(s)");

        var doctor = new Doctor.Builder()
                                .setDoctorID(doctorID)
                                .setPracticeName(practiceName)
                                .setFirstName(firstName)
                                .setLastName(lastName)
                                .setPhoneNumber(phoneNumber)
                                .build();
        return doctor;

    }

    private static boolean isInvalidParameters(String doctorID, String practiceName, String firstName, String lastName, String phoneNumber) {
        return (
                Helper.isNullOrEmpty(doctorID) ||
                Helper.isNullOrEmpty(practiceName) || Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(phoneNumber)
        );
    }
}
