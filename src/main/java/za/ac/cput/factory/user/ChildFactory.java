package za.ac.cput.factory.user;

import za.ac.cput.domain.user.Child;
import za.ac.cput.util.Helper;

/**
 *
 * This is the Child Factory
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
public class ChildFactory {

    public static Child createChild(String firstName, String lastName,
    String Address, String DOB, String Gender){

        if(notValid(firstName, lastName, Address, DOB, Gender))
            throw new IllegalArgumentException("Invalid values Entered");

        String contactID = Helper.generateID();
        return new Child.childBuilder()
                .setChildID(contactID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAddress(Address)
                .setDOB(DOB)
                .setGender(Gender)
                .build();

    }
    public static boolean notValid( String firstName, String lastName,
                                   String Address, String DOB, String Gender){

        if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)
                || Helper.isNullOrEmpty(Address) || Helper.isNullOrEmpty(DOB)
                || Helper.isNullOrEmpty(Gender)) return true;

        return false;

    }
}
