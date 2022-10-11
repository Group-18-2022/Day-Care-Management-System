package za.ac.cput.factory.user;

/* SecretaryFactory.java
   Factory for the Secretary
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import za.ac.cput.domain.user.Secretary;
import za.ac.cput.util.Helper;

public class SecretaryFactory {
    public static Secretary createSecretary(String firstName, String lastName, String dob) {
        String secretaryID = Helper.generateID();

        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(dob))
            throw new IllegalStateException("Invalid Values");

        var secretary = new Secretary.Builder()
                                                .setSecretaryID(secretaryID)
                                                .setFirstName(firstName)
                                                .setLastName(lastName)
                                                .setDob(dob)
                                                .build();
        return secretary;
    }
}
