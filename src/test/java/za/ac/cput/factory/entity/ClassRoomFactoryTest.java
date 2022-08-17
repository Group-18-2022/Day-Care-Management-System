package za.ac.cput.factory.entity;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entity.ClassRoom;
import za.ac.cput.factory.entity.ClassRoomFactory;

import static org.junit.jupiter.api.Assertions.*;

class ClassRoomFactoryTest
{
    ClassRoom classRoom;

    @Test
    public void testClassRoomCreation()
    {
        classRoom  = ClassRoomFactory.build("g07");
        assertNotNull(classRoom);
    }

    @Test
    public void testWithInvalidValues()
    {
        Exception exception = assertThrows(IllegalArgumentException.class,  () ->
        ClassRoomFactory.build(""));
        String expectedMessage = "Room Number is invalid";
        assertEquals(expectedMessage, exception.getMessage());
    }

}