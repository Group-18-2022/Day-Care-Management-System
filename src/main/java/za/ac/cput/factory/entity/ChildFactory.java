package za.ac.cput.factory.entity;

import za.ac.cput.domain.entity.Child;
import za.ac.cput.util.Helper;

/**
 *
 * This is the Child Factory
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
public class ChildFactory {

    public static Child createChild(String childID,String firstName, String lastName,
    String Address, String DOB, String Gender){


        Helper.checkStringParam("Child ID", childID);
        Helper.checkStringParam("First Name", firstName);
        Helper.checkStringParam("Last Name", lastName);
        Helper.checkStringParam("Address", Address);
        Helper.checkStringParam("Date of Birth", DOB);
        Helper.checkStringParam("Gender", Gender);

        return new Child.childBuilder()
                .setChildID(childID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAddress(Address)
                .setDOB(DOB)
                .setGender(Gender)
                .build();

    }
}
