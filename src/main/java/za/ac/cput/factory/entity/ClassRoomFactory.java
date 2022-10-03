package za.ac.cput.factory.entity;

import za.ac.cput.domain.entity.ClassRoom;
import za.ac.cput.util.Helper;

public class ClassRoomFactory
{
    private String classroomId;
    private String roomNumber;

    public static ClassRoom build(String identifier,String roomNumber)
    {

        if(Helper.isEmptyOrNull(identifier))
            throw new IllegalArgumentException("Classroom Id is invalid.");
        if(Helper.isEmptyOrNull(roomNumber))
            throw new IllegalArgumentException("Occupancy number is invalid");

        return new ClassRoom.Builder()
                .setClassroomId(identifier)
                .setRoomNumber(roomNumber)
                .build();
    }
}
