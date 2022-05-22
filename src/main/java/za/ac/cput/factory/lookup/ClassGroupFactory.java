package za.ac.cput.factory.lookup;

import za.ac.cput.domain.lookup.ClassGroup;
import za.ac.cput.util.Helper;

/**
 *
 * This is the ClassGroup Factory
 * @author Charles Moses Lemmert (220498385)
 *
 * **/
public class ClassGroupFactory {

    public static ClassGroup createClassGroup(int numOfRegStudent,boolean isJunior){

        if(Helper.isNullOrEmpty(numOfRegStudent) || Helper.isNullOrEmpty(isJunior))
            throw new IllegalArgumentException("Invalid values Entered");

        String classID = Helper.generateID();
        return new ClassGroup.classGroupBuilder()
                .setClassID(classID)
                .setNumOfRegStudent(numOfRegStudent)
                .setJunior(isJunior)
                .build();
    }
}
