package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.lookup.ClassRegister;
import za.ac.cput.factory.lookup.ClassRegisterFactory;
import za.ac.cput.repository.impl.lookup.ClassRegisterRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class ClassRegisterRepositoryImplTest {
    private static ClassRegisterRepositoryImpl classRegisterRepo = ClassRegisterRepositoryImpl.getClassRegisterRepo();
    private static ClassRegister classRegister = ClassRegisterFactory.createClassRegister("22f2-44as-65ad-55ar"
            ,"25d5-45as-85ad-77ar","22/05/2022",26);
    @Test
    void a_create() {
        ClassRegister createClassRegister = classRegisterRepo.create(classRegister);
        assertEquals(classRegister.getClassRoomID(), createClassRegister.getClassRoomID());
        System.out.println("New Class Register Record Created: \n"+ createClassRegister + "\n");
    }

    @Test
    void b_read() {
        ClassRegister readClassRegister = classRegisterRepo.read(classRegister.getRosterID());
        assertNotNull(readClassRegister);
        System.out.println("Class Register Record Has Been Retrieved: \n"+ readClassRegister + "\n");
    }

    @Test
    void c_update() {
        ClassRegister update = new ClassRegister.classRegisterBuilder().copy(classRegister)
                .setNumOfPresStudents(22)
                .setDate("24/05/2022")
                .build();
        ClassRegister updateClassRegister = classRegisterRepo.update(update);
        assertNotSame(classRegister,updateClassRegister);
        System.out.printf("Class Register Record: %n %s %nUpdated Class Register Record: %n %s %n"
                ,classRegister,updateClassRegister);
    }

    @Test
    void delete() {
        boolean deletingClassRegister = classRegisterRepo.delete(classRegister.getRosterID());
        assertTrue(deletingClassRegister);
        System.out.println("\nThe Record was deleted successfully: "+ deletingClassRegister + "\n");
    }

    @Test
    void getAllClassRegister() {

        assertNotNull(classRegisterRepo);
        System.out.println("All Class Register Records: \n"+ classRegisterRepo.getAllClassRegister());
    }
}