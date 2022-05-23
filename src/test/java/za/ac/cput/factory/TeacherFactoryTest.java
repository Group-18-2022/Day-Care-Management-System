package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.user.Teacher;
import za.ac.cput.factory.user.TeacherFactory;

import static org.junit.jupiter.api.Assertions.*;

class TeacherFactoryTest {
    @Test
    void buildWithErrors(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                TeacherFactory.build(null, "", "", "", ""));
        String expectedMessage = "Error: Invalid value(s)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void buildWithSuccess() {
        Teacher teacher = TeacherFactory
                .build("test-teacherID", "test-class-number","test-first-name", "test-last-name", "test-date-of-birth");
        System.out.println(teacher  );
        assertAll(
                () -> assertNotNull(teacher)
        );
    }


}



