package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.ClassGroup;
import za.ac.cput.factory.lookup.ClassGroupFactory;

import static org.junit.jupiter.api.Assertions.*;

class ClassGroupFactoryTest {
    ClassGroup classGroup;
    ClassGroup classGroupT;

    @BeforeEach
    public void startUp(){
        classGroup = ClassGroupFactory.createClassGroup("1",25,true);
        classGroupT = ClassGroupFactory.createClassGroup("2",30,false);
    }

    @Test
    public void creationOfClassGroupFailingTest(){
        ClassGroup createClassGroupObj = ClassGroupFactory.createClassGroup("1",-25,true);
        System.out.println("\nClass Group Object has not been created due to invalid value:" + createClassGroupObj);
        assertEquals(null,createClassGroupObj);
    }

    @Test
    public void creationOfClassGroupPassingTest(){
        ClassGroup createClassGroupObj = ClassGroupFactory.createClassGroup("1",25,true);
        assertNotNull(createClassGroupObj.toString());
        System.out.println("\nClass Group Object has been created:");
        System.out.println(createClassGroupObj);
    }
    @Test
    public void ClassGroupEqualityTest(){
        assertNotEquals(classGroup,classGroupT);
        System.out.printf("%nObject 1: %n %s %nObject 2: %n %s " +
                "%nObject 1 is not the same as Object 2",classGroup,classGroupT);
    }

}