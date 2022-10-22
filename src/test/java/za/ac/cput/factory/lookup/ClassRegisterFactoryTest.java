package za.ac.cput.factory.lookup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.ClassRegister;

import static org.junit.jupiter.api.Assertions.*;

class ClassRegisterFactoryTest {
    ClassRegister classRegister;
    ClassRegister classRegisterT;

    @BeforeEach
    public void setUp(){
        classRegister = ClassRegisterFactory.createClassRegister("1"
        ,"1","1","1",25);
        classRegister = ClassRegisterFactory.createClassRegister("2",
                "2","2","2",29);
    }

    @Test
    public void creationOfClassRegisterFailingTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ClassRegisterFactory.createClassRegister("1","1","1","",25);
        });
        String errorMsg = "Invalid value for params: Class ID";
        String returneMsg = exception.getMessage();
        assertTrue(returneMsg.contains(errorMsg));
    }

    @Test
    public void creationOfClassRegisterPassingTest(){
        ClassRegister createClassRegisterObj = ClassRegisterFactory.createClassRegister("1"
                ,"1","1","1",25);
        assertNotNull(createClassRegisterObj.toString());
        System.out.println("\nClass Register Object has been created:");
        System.out.println(createClassRegisterObj);
    }

    @Test
    public void classRegisterEqualityTest(){
        assertNotEquals(classRegister,classRegisterT);
        System.out.printf("%nObject 1: %n %s %nObject 2: %n %s %nObject 1 is not the same as Object 2",classRegister,classRegisterT);
    }

}