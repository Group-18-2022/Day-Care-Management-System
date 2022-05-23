package za.ac.cput.factory.entity;

import za.ac.cput.domain.entity.Parent;
import za.ac.cput.util.Helper;

/* Author : Karl Haupt
 * Student Number: 220236585
 */

//TODO: Valid phoneNumber + test case

public class ParentFactory {

    public static Parent buildParent(String firstName, String lastName, String address, String phoneNumber) {
        String parentID = Helper.generateID();

        if (isInvalidParameters(parentID, firstName, lastName, address, phoneNumber))
            throw new IllegalArgumentException("Error: Invalid value(s)");

        return new Parent.Builder()
                .setParentID(parentID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAddress(address)
                .setPhoneNumber(phoneNumber)
                .build();

    }

    private static boolean isInvalidParameters(String parentID, String firstName, String lastName, String address, String phoneNumber) {
        return (
                Helper.isNullOrEmpty(parentID) ||
                Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(address) ||
                Helper.isNullOrEmpty(phoneNumber)
        );
    }
}
