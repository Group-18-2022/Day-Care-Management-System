package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.lookup.ClassGroup;
import za.ac.cput.factory.lookup.ClassGroupFactory;
import za.ac.cput.repository.impl.lookup.ClassGroupRespositoryImpl;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class ClassGroupRespositoryImplTest {
    private static ClassGroupRespositoryImpl classGroupRepo = ClassGroupRespositoryImpl.getClassGroupRepo();
    private static ClassGroup classGroup =  ClassGroupFactory.createClassGroup(25,true);
    @Test
    void a_create() {
        ClassGroup createClassGroup = classGroupRepo.create(classGroup);
        assertEquals(classGroup.getClassID(),createClassGroup.getClassID());
        System.out.println("New Class Group Record Created: \n"+ createClassGroup + "\n");
    }

    @Test
    void b_read() {
        ClassGroup  readClassGroup = classGroupRepo.read(classGroup.getClassID());
        assertNotNull(readClassGroup);
        System.out.println("Class Group Record Has Been Retrieved: \n"+ readClassGroup + "\n");
    }

    @Test
    void c_update() {
        ClassGroup update = new ClassGroup.classGroupBuilder().copy(classGroup)
                .setJunior(false)
                .build();
        ClassGroup updateClassGroup = classGroupRepo.update(update);
        assertNotSame(classGroup,updateClassGroup);
        System.out.printf("Class Group Record: %n %s %nUpdated Class Group Record: %n %s %n"
                ,classGroup,updateClassGroup);
    }

    @Test
    void d_delete() {
        boolean deletingClassGroup = classGroupRepo.delete(classGroup.getClassID());
        assertTrue(deletingClassGroup);
        System.out.println("\nThe Record was deleted successfully: "+ deletingClassGroup + "\n");
    }

    @Test
    void getAllClassGroups() {
        assertNotNull(classGroupRepo);
        System.out.println("All Club Records: \n"+ classGroupRepo.getAllClassGroups());
    }
}