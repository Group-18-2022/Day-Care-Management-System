package za.ac.cput.factory.user;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import za.ac.cput.domain.user.Teacher;

public class TeacherFactory {
    public static Teacher build (String teacherID, String classNumber, String firstName, String lastName, String dateOfBirth){
        if(teacherID == null || teacherID.isEmpty())
            throw new IllegalArgumentException("Teacher ID is required!");
        if(classNumber == null || classNumber.isEmpty())
            throw new IllegalArgumentException("Class number is required!");
        if(firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException("First name is required!");
        if(lastName == null || lastName.isEmpty())
            throw new IllegalArgumentException("Last name is required!");
        if(dateOfBirth == null || dateOfBirth.isEmpty())
            throw new IllegalArgumentException("Contact is required!");
        return new Teacher.Builder().teacherID(teacherID)
                .classNumber(classNumber).firstName(firstName).lastName(lastName).dateOfBirth(dateOfBirth).build();
    }

}
