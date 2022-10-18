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


<<<<<<< HEAD
        Helper.checkStringParam("Contact ID", childID);
=======
        Helper.checkStringParam("Child ID", childID);
>>>>>>> cc064a89be4ca5c790569f7e441dc0d992146664
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
