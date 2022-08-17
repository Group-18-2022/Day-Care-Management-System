package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.ClassRegister;
import za.ac.cput.factory.lookup.ClassRegisterFactory;

import static org.junit.jupiter.api.Assertions.*;

class ClassRegisterFactoryTest {
    ClassRegister classRegister;
    ClassRegister classRegisterT;

    @BeforeEach
    public void setUp(){
        classRegister = ClassRegisterFactory.createClassRegister("22d2-33as-55ad-62ar"
        ,"22d5-34as-85ad-66ar","22d5-34as-85ad-66we","22d5-34as-552d-66ar","22/05/2022",25);
        classRegister = ClassRegisterFactory.createClassRegister("22f2-44as-65ad-55ar",
                "25d5-45as-85ad-77ar","22d5-34as-552d-77ar","2555-34as-85ad-66we","22/05/2022",29);
    }

    @Test
    public void creationOfClassRegisterFailingTest(){
        ClassRegister createClassRegisterObj = ClassRegisterFactory.createClassRegister("22d2-33as-55ad-62ar"
                ,"22d5-34as-85ad-66ar","22d5-34as-85ad-66we","22d5-34as-552d-66ar","22/05/2022",25);
        System.out.println("\nClass Register Object has not been created" + createClassRegisterObj);
        assertEquals(null,createClassRegisterObj);
    }

    @Test
    public void creationOfClassRegisterPassingTest(){
        ClassRegister createClassRegisterObj = ClassRegisterFactory.createClassRegister("22d2-33as-55ad-62ar"
                ,"22d5-34as-85ad-66ar","22d5-34as-85ad-66we","22d5-34as-552d-66ar","22/05/2022",25);
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