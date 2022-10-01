package za.ac.cput.repository.lookup;
/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.lookup.TeacherClass;

import java.util.List;
import java.util.Optional;

public interface ITeacherClassRepository extends JpaRepository<TeacherClass, String> {
    //Optional<TeacherClass> findTeacherClassByRoomId(String roomId);
}
