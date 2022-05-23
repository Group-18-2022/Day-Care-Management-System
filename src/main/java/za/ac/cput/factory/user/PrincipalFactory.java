package za.ac.cput.factory.user;

/* PrincipalFactory.java
   Factory for the Principal
   Author: Joshua Daniel Jonkers(215162668)
   Date: 22/05/2022
 */

import za.ac.cput.domain.user.Principal;
import za.ac.cput.util.Helper;

public class PrincipalFactory {
    public static Principal createPrincipal(String firstName, String lastName, String dob) {
        String principalID = Helper.generateID();

        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(dob))
            throw new IllegalStateException("Invalid Values");

        var principal = new Principal.Builder()
                                                .setPrincipalID(principalID)
                                                .setFirstName(firstName)
                                                .setLastName(lastName)
                                                .setDob(dob)
                                                .build();
        return principal;
    }
}
