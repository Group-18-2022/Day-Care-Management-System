package za.ac.cput.factory.lookup;

import za.ac.cput.domain.lookup.ClassRegister;
import za.ac.cput.util.Helper;

/**
 *
 * This is the ClassRegister Factory
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
public class ClassRegisterFactory {

    public static ClassRegister createClassRegister(String teacherID,
    String classRoomID,String date,int numOfPresStudents){
        if(notValid(teacherID,classRoomID,date,numOfPresStudents))
            throw new IllegalArgumentException("Invalid values Entered");

        String rosterID = Helper.generateID();
        return new ClassRegister.classRegisterBuilder()
                .setRosterID(rosterID)
                .setTeacherID(teacherID)
                .setClassRoomID(classRoomID)
                .setDate(date)
                .setNumOfPresStudents(numOfPresStudents)
                .build();
    }

    public static boolean notValid(String teacherID,String classRoomID,String date,int numOfPresStudents){

        if(Helper.isNullOrEmpty(teacherID) || Helper.isNullOrEmpty(classRoomID)
                || Helper.isNullOrEmpty(date)
                || Helper.isNullOrEmpty(numOfPresStudents)) return true;

        return false;

    }
}
