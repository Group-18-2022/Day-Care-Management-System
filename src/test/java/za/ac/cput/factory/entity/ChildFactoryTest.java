package za.ac.cput.factory.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entity.Child;
import za.ac.cput.factory.entity.ChildFactory;


import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class ChildFactoryTest {
    Child child;
    Child childT;

    @BeforeEach void setUp(){
        child = ChildFactory.createChild("1","James","Johnson",
                "72 Anderson Street, Townsend Estate, Cape Town, 7460",
                "09/05/2017","Male");
        childT = ChildFactory.createChild("2","Emily","Johnson",
                "72 Anderson Street, Townsend Estate, Cape Town, 7460",
                "09/05/2018","female");
    }
    @Test
    public void creationOfChildValidationFallingTest(){
        Child createChildObj = ChildFactory.createChild("1","Emily","",
                "72 Anderson Street, Townsend Estate, Cape Town, 7460",
                "09/05/2018","female");
        System.out.println("\nChild Object has not been created due to invalid value: " + createChildObj);
        assertEquals(null, createChildObj);
    }
    @Test
    public void creationOfChildalidationPassingTest(){
        Child createChildObj = ChildFactory.createChild("1","Emily","Johnson",
                "72 Anderson Street, Townsend Estate, Cape Town, 7460",
                "09/05/2018","female");
        assertNotNull(createChildObj.toString());
        System.out.println("\nChild Object has been created:");
        System.out.println(createChildObj);
    }
    @Test
    public void childEqualityTest(){
        assertNotEquals(child, childT);
        System.out.printf("%nObject 1: %n %s %nObject 2: %n %s " +
                "%nObject 1 is not the same as Object 2",child,childT);
    }
}