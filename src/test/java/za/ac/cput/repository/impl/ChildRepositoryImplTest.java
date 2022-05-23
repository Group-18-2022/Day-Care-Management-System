package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.user.Child;
import za.ac.cput.factory.user.ChildFactory;
import za.ac.cput.repository.impl.user.ChildRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class ChildRepositoryImplTest {
    private static ChildRepositoryImpl childRepository = ChildRepositoryImpl.getChildRepo();
    private static Child child = ChildFactory.createChild("James","Johnson",
            "72 Anderson Street, Townsend Estate, Cape Town, 7460",
            "09/05/2017","Male");
    @Test
    void a_create() {
        Child  createChild = childRepository.create(child);
        assertEquals(child.getChildID(), createChild.getChildID());
        System.out.println("New Child Record Created: \n"+ createChild + "\n");
    }

    @Test
    void b_read() {
        Child readChild = childRepository.read(child.getChildID());
        assertNotNull(readChild);
        System.out.println("Child Record Has Been Retrieved: \n"+ readChild + "\n");
    }

    @Test
    void c_update() {
        Child update = new Child.childBuilder().copy(child)
                .setFirstName("Auston")
                .setLastName("Luke")
                .build();
        Child  updateChild = childRepository.update(update);
        assertNotSame(child, updateChild);
        System.out.printf("Child Record: %n %s %nUpdated Child Record: %n %s %n"
                ,child,updateChild);
    }

    @Test
    void d_delete() {
        boolean deletingChild = childRepository.delete(child.getChildID());
        assertTrue(deletingChild);
        System.out.println("\nThe Record was deleted successfully: "+ deletingChild + "\n");
    }

    @Test
    void e_getAllChildren() {
        assertNotNull(childRepository);
        System.out.println("All Club Records: \n"+ childRepository.getAllChildren());
    }
}